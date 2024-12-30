package cn.edu.zjut.javaeeteachers.service;

import cn.edu.zjut.javaeeteachers.model.Role;
import cn.edu.zjut.javaeeteachers.model.Teacher_Course;
import cn.edu.zjut.javaeeteachers.model.User;
import cn.edu.zjut.javaeeteachers.model.UserDto;
import cn.edu.zjut.javaeeteachers.repository.TeacherCourseRepository;
import cn.edu.zjut.javaeeteachers.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final TeacherCourseRepository teacherCourseRepository;

    public UserService(UserRepository userRepository, TeacherCourseRepository teacherCourseRepository) {
        this.userRepository = userRepository;
        this.teacherCourseRepository = teacherCourseRepository;
    }


    // 用户注册
    @Transactional
    public void registerUser(UserDto userDto) {
        // Step 1: 检查用户名是否已存在
        Optional<User> existingUser = userRepository.findByUsername(userDto.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("用户名已存在，请选择其他用户名！");
        }

        // Step 2: 创建用户实体
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());  // 这里的密码没有加密
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());

        // Step 3: 保存用户到数据库
        userRepository.save(user);  // 注意：此处保存用户后会返回保存的用户对象

        // Step 4: 如果角色为 TEACHER，关联课程（教师注册功能）
        if (Role.TEACHER.equals(userDto.getRole()) && userDto.getCourses() != null) {
            List<Teacher_Course> teacherCourses = userDto.getCourses().stream()
                    .map(courseId -> new Teacher_Course(user.getUserId(), courseId))  // 使用 user.getUserId()
                    .toList();
            teacherCourseRepository.saveAll(teacherCourses); // 批量保存课程关联
        }
    }

    // 用户登录
    @Transactional
    public User loginUser(UserDto userDto) {
        // 通过用户名从数据库查找用户
        Optional<User> existingUser = userRepository.findByUsername(userDto.getUsername());

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            // 检查密码是否匹配，假设密码是以明文保存
            if (user.getPassword().equals(userDto.getPassword())) {
                try {
                    // 直接使用 user.getRole()，因为它已经是枚举类型，没必要再转换
                    Role userRole = user.getRole(); // 获取枚举类型
                    if (userRole == Role.TEACHER) {
                        return user; // 登录成功，返回用户信息
                    } else {
                        throw new RuntimeException("用户角色不匹配！");
                    }
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("无效的用户角色：" + user.getRole());
                }
            } else {
                throw new RuntimeException("用户名或密码错误！");
            }
        } else {
            throw new RuntimeException("用户名不存在！");
        }
    }


}

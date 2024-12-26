package cn.edu.zjut.javaeeteachers.service;

import cn.edu.zjut.javaeeteachers.model.*;
import cn.edu.zjut.javaeeteachers.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password, String email, Role role, List<String> courseNames) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("用户名已存在");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRole(role);
        userRepository.save(user);

        for (String courseName : courseNames) {
            Course course = courseRepository.findByCourseName(courseName)
                    .orElseThrow(() -> new RuntimeException("课程不存在: " + courseName));
            // 根据角色将课程关联逻辑写入
        }
    }
}


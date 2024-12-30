package cn.edu.zjut.javaeeteachers.service;

import cn.edu.zjut.javaeeteachers.model.User;
import cn.edu.zjut.javaeeteachers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 注册用户
    public boolean registerUser(String username, String password, String email, String role) {
        if (userRepository.findByUsername(username) != null) {
            return false; // 用户名已存在
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        userRepository.save(user);

        return true;
    }

    // 登录用户
    public User loginUser(String username, String password) {
        System.out.println("用户: " + username + " 正在尝试登录...");
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("用户: " + username + " 未找到！");
            return null; // 用户不存在，返回 null
        }
        System.out.println("用户: " + user.getUsername() + " 已找到！");
        if (user.getPassword().equals(password)) {
            return user; // 密码正确，返回用户对象
        } else {
            System.out.println("用户: " + username + " 密码不对！");
            return null; // 密码错误，返回 null
        }
    }

}
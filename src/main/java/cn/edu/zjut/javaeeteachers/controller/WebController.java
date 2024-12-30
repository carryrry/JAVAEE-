package cn.edu.zjut.javaeeteachers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // 显示注册页面
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "registration"; // 返回的 "registration" 会自动映射到 resources/templates/registration.html
    }

    // 显示登录页面
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // 映射到 resources/templates/login.html
    }
}

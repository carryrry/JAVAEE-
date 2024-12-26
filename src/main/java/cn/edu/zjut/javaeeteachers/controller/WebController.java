package cn.edu.zjut.javaeeteachers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "registration"; // 返回的 "registration" 会自动映射到 resources/templates/registration.html
    }
}

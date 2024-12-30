package cn.edu.zjut.javaeeteachers.controller;

import cn.edu.zjut.javaeeteachers.model.User;
import cn.edu.zjut.javaeeteachers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 注册页面
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // 处理注册请求
    @PostMapping("/register")
    public String register(String username, String password, String email, String role, Model model) {
        boolean success = userService.registerUser(username, password, email, role);
        if (success) {
            return "login"; // 注册成功跳转到登录页面
        } else {
            model.addAttribute("error", "用户名已存在！"); // 将错误信息传递到视图
            return "register";
        }
    }

    // 登录页面
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 处理登录请求
    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            // 根据角色跳转到不同页面
            String role = user.getRole(); // 获取用户角色
            switch (role) {
                case "student":
                    return "redirect:/student";  // 跳转到学生页面
                case "teacher":
                    return "redirect:/teacher";  // 跳转到教师页面
                case "exam_admin":
                    return "redirect:/exam_admin";    // 跳转到管理员页面
                default:
                    return "redirect:/home";    // 如果角色未知，跳转到主页
            }
        } else {
            model.addAttribute("error", "用户名或密码错误！");
            return "login";  // 登录失败，返回登录页面
        }
    }

    // 主页
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // 学生页面
    @GetMapping("/student")
    public String studentPage() {
        return "student"; // 返回学生页面的视图
    }

    // 教师页面
    @GetMapping("/teacher")
    public String teacherPage() {
        return "teacher"; // 返回教师页面的视图
    }

    // 管理员页面
    @GetMapping("/exam_admin")
    public String adminPage() {
        return "exam_admin"; // 返回管理员页面的视图
    }
}

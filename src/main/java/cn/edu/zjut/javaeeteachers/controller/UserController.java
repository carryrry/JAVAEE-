package cn.edu.zjut.javaeeteachers.controller;


import cn.edu.zjut.javaeeteachers.model.Role;
import cn.edu.zjut.javaeeteachers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam Role role,
            @RequestParam List<String> courseNames
    ) {
        try {
            userService.registerUser(username, password, email, role, courseNames);
            return ResponseEntity.ok("注册成功");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}



package cn.edu.zjut.javaeeteachers.model;

import lombok.Data;

import java.util.List;


@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private Role role;
    private List<Integer> courses;  // 选中的课程 ID 列表

}


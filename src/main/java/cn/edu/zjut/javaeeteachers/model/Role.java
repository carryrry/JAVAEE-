package cn.edu.zjut.javaeeteachers.model;

public enum Role {
    STUDENT, TEACHER, EXAM_ADMIN;

    public static Role fromString(String role) {
        try {
            return Role.valueOf(role.toUpperCase()); // 将数据库值转换为大写匹配枚举
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("无效的角色值：" + role);
        }
    }
}
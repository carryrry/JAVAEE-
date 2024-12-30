package cn.edu.zjut.javaeeteachers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// Getters and setters(lombok)
@Data
@Entity
@Table(name = "teacher_courses")
public class Teacher_Course {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "course_id")
    private Integer courseId;

    public Teacher_Course() {

    }
    // 这里添加一个匹配的构造方法
    public Teacher_Course(Integer userId, Integer courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

}

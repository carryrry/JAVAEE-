package cn.edu.zjut.javaeeteachers.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String courseTime;

}


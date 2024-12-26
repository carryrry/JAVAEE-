package cn.edu.zjut.javaeeteachers.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")  // 确保这里是表名 courses
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 使用数据库自增主键
    @Column(name = "course_id")  // 对应数据库中的列名
    private Integer courseId;

    @Column(name = "course_name")  // 对应数据库中的列名
    private String courseName;

    @Column(name = "course_time")  // 对应数据库中的列名
    private String courseTime;

    // Getters and Setters

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
}

package cn.edu.zjut.javaeeteachers.controller;

import cn.edu.zjut.javaeeteachers.model.Course;
import cn.edu.zjut.javaeeteachers.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/api/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
}

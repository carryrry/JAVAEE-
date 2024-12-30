package cn.edu.zjut.javaeeteachers.service;

import cn.edu.zjut.javaeeteachers.model.Course;
import cn.edu.zjut.javaeeteachers.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}

package cn.edu.zjut.javaeeteachers.service;

import cn.edu.zjut.javaeeteachers.model.Course;
import cn.edu.zjut.javaeeteachers.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}

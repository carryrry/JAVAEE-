package cn.edu.zjut.javaeeteachers.repository;

import cn.edu.zjut.javaeeteachers.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findByCourseName(String courseName);
}


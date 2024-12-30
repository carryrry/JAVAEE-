CREATE TABLE student_courses (
                                 student_id INT,
                                 course_id INT,
                                 FOREIGN KEY (student_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                 FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
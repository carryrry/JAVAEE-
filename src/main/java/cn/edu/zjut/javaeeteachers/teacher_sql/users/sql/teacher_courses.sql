CREATE TABLE teacher_courses (
                                 teacher_id INT,
                                 course_id INT,
                                 PRIMARY KEY (teacher_id, course_id),
                                 FOREIGN KEY (teacher_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                 FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
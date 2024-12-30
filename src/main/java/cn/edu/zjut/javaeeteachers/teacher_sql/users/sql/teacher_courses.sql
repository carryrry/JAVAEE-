CREATE TABLE teacher_courses (
                                 user_id INT,
                                 course_id INT,
                                 FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                 FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
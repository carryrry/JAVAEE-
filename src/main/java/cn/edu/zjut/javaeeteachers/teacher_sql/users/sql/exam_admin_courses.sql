CREATE TABLE exam_admin_courses (
                                    exam_admin_id INT,
                                    course_id INT,
                                    PRIMARY KEY (exam_admin_id, course_id),
                                    FOREIGN KEY (exam_admin_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
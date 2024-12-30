CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE, -- 保持用户名唯一
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255),
                       role ENUM('student', 'teacher', 'exam_admin') NOT NULL
);
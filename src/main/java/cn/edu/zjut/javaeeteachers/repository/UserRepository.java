package cn.edu.zjut.javaeeteachers.repository;

import cn.edu.zjut.javaeeteachers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
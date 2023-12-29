package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByEmailIgnoreCase(String email);
    User findByUsernameIgnoreCase(String username);
    User findById(Integer userId);

    // New method to check if a user with the given username or email already exists
    boolean existsByEmailIgnoreCase(String email);
}

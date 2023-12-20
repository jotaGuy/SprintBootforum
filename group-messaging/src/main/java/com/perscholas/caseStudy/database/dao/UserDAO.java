package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByEmailIgnoreCase(String email);
    User findByUsernameIgnoreCase(String username); // Add this method
}

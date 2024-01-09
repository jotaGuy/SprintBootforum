package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Posts;
import com.perscholas.caseStudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    List<User> findAll();
    User findByEmailIgnoreCase(String email);

    // can add native query
    User findByUsernameIgnoreCase(String username);
    User findById(Integer userId);

    // New method to check if a user with the given username or email already exists
    boolean existsByEmailIgnoreCase(String email);
}

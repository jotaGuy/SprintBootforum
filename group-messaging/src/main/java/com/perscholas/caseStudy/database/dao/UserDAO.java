package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.enity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Users, Long> {
    public Users findByEmailIgnoreCase(String email);
}

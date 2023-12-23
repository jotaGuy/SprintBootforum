package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Topics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicsDAO extends JpaRepository<Topics, Long> {

    // You don't need a custom query to get all topics
    List<Topics> findAll();
    Topics findByTopic(String topic);
}


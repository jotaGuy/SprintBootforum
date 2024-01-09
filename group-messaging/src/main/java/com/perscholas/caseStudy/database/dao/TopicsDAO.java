package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Posts;
import com.perscholas.caseStudy.database.entity.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicsDAO extends JpaRepository<Topics, Long> {

    // You don't need a custom query to get all topics
    List<Topics> findAll();
    Topics findByTopic(String topic);

    @Query(value = "SELECT * FROM topics WHERE user_id = :userId", nativeQuery = true)
    List<Topics> findByUserId(@Param("userId") Integer userId);
}


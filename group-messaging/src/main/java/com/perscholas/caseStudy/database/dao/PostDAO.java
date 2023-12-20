package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostDAO extends JpaRepository<Posts, Long> {

    @Query("SELECT m FROM Posts m WHERE m.topic LIKE :topic")
    List<Posts> findByTopic(String topic);
}


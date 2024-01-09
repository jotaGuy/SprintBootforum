package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostDAO extends JpaRepository<Posts, Long> {

    @Query("SELECT m FROM Posts m WHERE m.topic LIKE :topic")
    List<Posts> findByTopic(String topic);

    @Query(value = "SELECT * FROM Post WHERE user_id = :userId", nativeQuery = true)
    List<Posts> findByUserId(@Param("userId") Integer userId);

}

package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessagesDAO extends JpaRepository<Messages, Long> {

    @Query("SELECT m FROM Messages m WHERE m.topic LIKE :topic")
    List<Messages> findByTopic(String topic);
}


package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface CommentDAO extends JpaRepository<Comments, Long> {

    @Query("SELECT c FROM Comments c WHERE c.postId = :postId")
    List<Comments> findByPostId(Integer postId);
}

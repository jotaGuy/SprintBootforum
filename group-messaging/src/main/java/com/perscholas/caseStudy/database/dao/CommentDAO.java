package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Comments;
import com.perscholas.caseStudy.database.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface CommentDAO extends JpaRepository<Comments, Long> {

    @Query("SELECT c FROM Comments c WHERE c.postId = :postId")
    List<Comments> findByPostId(Integer postId);

    @Query(value = "SELECT * FROM comments WHERE user_id = :userId", nativeQuery = true)
    List<Comments> findByUserId(@Param("userId") Integer userId);
}

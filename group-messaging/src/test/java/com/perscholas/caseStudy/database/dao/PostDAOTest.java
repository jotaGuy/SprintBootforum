package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Posts;
import com.perscholas.caseStudy.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@SpringBootTest
public class PostDAOTest {

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    void createTest() {
        log.info("Running createTest for Posts");
        // Arrange
        User user = new User();
        user.setUsername("testUser4");
        user.setEmail("test4@example.com");
        user.setPassword("testPassword2");

        // Save the user first
        User savedUser = userDAO.save(user);

        Posts post = new Posts();
        post.setUserId(savedUser);
        post.setTitle("TestTitle");
        post.setMessage("TestMessage");
        post.setTopic("TestTopic");

        // Act
        Posts savedPost = postDAO.save(post);

        // Assert
        Assertions.assertNotNull(savedPost.getId());

        // Query the database to check if the post exists
        Posts retrievedPost = postDAO.findById(Long.valueOf(savedPost.getId())).orElse(null);
        Assertions.assertNotNull(retrievedPost);

        // Check post attributes
        Assertions.assertEquals("TestTitle", retrievedPost.getTitle());
        Assertions.assertEquals("TestMessage", retrievedPost.getMessage());
        Assertions.assertEquals("TestTopic", retrievedPost.getTopic());

        log.info("createTest for Posts completed");
    }

    @Test
    @Order(2)
    void topicNotInDatabaseTest() {
        log.info("Running readByTopicTest for Posts");
        // Query the database for posts with a specific topic
        List<Posts> postsList = postDAO.findByTopic("TestTopic");
        Assertions.assertFalse(postsList.isEmpty());

        // Add additional assertions as needed

        log.info("readByTopicTest for Posts completed");
    }

    @ParameterizedTest
    @Order(3)
    @MethodSource("getPostTitles")
    void readByTitleTest(String title) {
        log.info("Running readByTitleTest for Posts");
        // Query the database for posts with a specific title
        List<Posts> postsList = postDAO.findByTopic(title);
        Assertions.assertFalse(postsList.isEmpty());

        // Add additional assertions as needed

        log.info("readByTitleTest for Posts completed");
    }

    @Test
    @Order(4)
    void updateTest() {
        log.info("Running updateTest for Posts");
        // Query the database to get the post
        Posts post = postDAO.findByTopic("TestTopic").get(0);
        Assertions.assertNotNull(post);

        // Update post attributes
        post.setMessage("UpdatedMessage");
        Posts updatedPost = postDAO.save(post);

        // Assert
        Assertions.assertEquals("UpdatedMessage", updatedPost.getMessage());

        // Query the database to get the updated post
        Posts retrievedPost = postDAO.findById(Long.valueOf(updatedPost.getId())).orElse(null);

        // Check post attributes
        Assertions.assertNotNull(retrievedPost);
        Assertions.assertEquals("UpdatedMessage", retrievedPost.getMessage());

        log.info("updateTest for Posts completed");
    }

    @Test
    @Order(5)
    void deleteTest() {
        log.info("Running deleteTest for Posts");
        // Query the database to get posts with a specific topic
        List<Posts> postsList = postDAO.findByTopic("TestTopic");
        Assertions.assertFalse(postsList.isEmpty());

        // Delete the posts
        for (Posts post : postsList) {
            postDAO.delete(post);
        }

        // Query the database to check if the posts are deleted
        List<Posts> deletedPostsList = postDAO.findByTopic("TestTopic");
        Assertions.assertTrue(deletedPostsList.isEmpty());

        log.info("deleteTest for Posts completed");
    }

    private static Stream<String> getPostTitles() {
        return Stream.of("TestTopic");
    }
}

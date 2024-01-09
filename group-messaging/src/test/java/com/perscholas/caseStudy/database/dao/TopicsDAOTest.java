package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Topics;
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
public class TopicsDAOTest {

    @Autowired
    private TopicsDAO topicsDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    void createTest() {
        log.info("Running createTest for Topics");
        // Arrange
        User user = new User();
        user.setUsername("testUser1");
        user.setEmail("test1@example.com");
        user.setPassword("testPassword1");

        // Save the user first
        User savedUser = userDAO.save(user);

        Topics topic = new Topics();
        topic.setUserId(savedUser);
        topic.setTopic("TestTopic");
        topic.setDescription("TestDescription");

        // Act
        Topics savedTopic = topicsDAO.save(topic);

        // Assert
        Assertions.assertNotNull(savedTopic.getId());

        // Query the database to check if the topic exists
        Topics retrievedTopic = topicsDAO.findById(Long.valueOf(savedTopic.getId())).orElse(null);
        Assertions.assertNotNull(retrievedTopic);

        // Check topic attributes
        Assertions.assertEquals("TestTopic", retrievedTopic.getTopic());
        Assertions.assertEquals("TestDescription", retrievedTopic.getDescription());

        log.info("createTest for Topics completed");
    }

    @Test
    @Order(2)
    void readAllTest() {
        log.info("Running readAllTest for Topics");
        // Query the database to get all topics
        List<Topics> topicsList = topicsDAO.findAll();
        Assertions.assertFalse(topicsList.isEmpty());

        // Add additional assertions as needed

        log.info("readAllTest for Topics completed");
    }

    @ParameterizedTest
    @Order(3)
    @MethodSource("getTopicNames")
    void readByTopicTest(String topicName) {
        log.info("Running readByTopicTest for Topics");
        // Query the database for the topic using the provided topicName
        Topics topic = topicsDAO.findByTopic(topicName);
        Assertions.assertNotNull(topic);

        // Check topic attributes
        Assertions.assertEquals(topicName, topic.getTopic());

        log.info("readByTopicTest for Topics completed");
    }

    @Test
    @Order(4)
    void updateTest() {
        log.info("Running updateTest for Topics");
        // Query the database to get the topic
        Topics topic = topicsDAO.findByTopic("TestTopic");
        Assertions.assertNotNull(topic);

        // Update topic attributes
        topic.setDescription("UpdatedDescription");
        Topics updatedTopic = topicsDAO.save(topic);

        // Assert
        Assertions.assertEquals("UpdatedDescription", updatedTopic.getDescription());

        // Query the database to get the updated topic
        Topics retrievedTopic = topicsDAO.findById(Long.valueOf(updatedTopic.getId())).orElse(null);

        // Check topic attributes
        Assertions.assertNotNull(retrievedTopic);
        Assertions.assertEquals("UpdatedDescription", retrievedTopic.getDescription());

        log.info("updateTest for Topics completed");
    }

    @Test
    @Order(5)
    void deleteTest() {
        log.info("Running deleteTest for Topics");
        // Query the database to get the topic
        Topics topic = topicsDAO.findByTopic("TestTopic");
        Assertions.assertNotNull(topic);

        // Delete the topic
        topicsDAO.delete(topic);

        // Query the database to check if the topic is deleted
        Topics deletedTopic = topicsDAO.findByTopic("TestTopic");
        Assertions.assertNull(deletedTopic);

        log.info("deleteTest for Topics completed");
    }

    private static Stream<String> getTopicNames() {
        return Stream.of("TestTopic");
    }
}

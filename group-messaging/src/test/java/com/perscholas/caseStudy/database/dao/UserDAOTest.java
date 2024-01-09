package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@Slf4j
@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    void createTest() {
        log.info("Running createTest for User");
        // Arrange
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("testPassword1"); // Set a password for the user

        // Act
        User savedUser = userDAO.save(user);

        // Assert
        Assertions.assertNotNull(savedUser.getId());

        // Query the database to check if the user exists
        User retrievedUser = userDAO.findById(savedUser.getId());
        Assertions.assertNotNull(retrievedUser);

        // Check user attributes
        Assertions.assertEquals("testUser", retrievedUser.getUsername());
        Assertions.assertEquals("test@example.com", retrievedUser.getEmail());
        Assertions.assertEquals("testPassword1", retrievedUser.getPassword());

        log.info("createTest for User completed");
    }

    @Test
    @Order(2)
    void readTest() {
        log.info("Running readTest for User");
        // Query the database for the user using the provided userId
        User retrievedUser = userDAO.findById(1);

        // Assert
        Assertions.assertNotNull(retrievedUser);

        // Check user attributes
        Assertions.assertEquals("testUser", retrievedUser.getUsername());
        Assertions.assertEquals("test@example.com", retrievedUser.getEmail());
        Assertions.assertEquals("testPassword1", retrievedUser.getPassword());

        log.info("readTest for User completed");
    }

    @Test
    @Order(3)
    void updateTest() {
        log.info("Running updateTest for User");
        // Query the database to get the user
        User user = userDAO.findByUsernameIgnoreCase("testUser");
        Assertions.assertNotNull(user);

        // Update user attributes
        user.setUsername("updatedUser");
        User updatedUser = userDAO.save(user);

        // Assert
        Assertions.assertEquals("updatedUser", updatedUser.getUsername());

        // Query the database to get the updated user
        User retrievedUser = userDAO.findById(updatedUser.getId());

        // Check user attributes
        Assertions.assertEquals("updatedUser", retrievedUser.getUsername());
        Assertions.assertEquals("test@example.com", retrievedUser.getEmail());
        Assertions.assertEquals("testPassword1", retrievedUser.getPassword());

        log.info("updateTest for User completed");
    }

    @Test
    @Order(4)
    void deleteTest() {
        log.info("Running deleteTest for User");
        // Query the database to get the user
        User user = userDAO.findByUsernameIgnoreCase("updatedUser");
        Assertions.assertNotNull(user);

        // Delete the user
        userDAO.delete(user);

        // Query the database to check if the user is deleted
        User deletedUser = userDAO.findByUsernameIgnoreCase("updatedUser");
        Assertions.assertNull(deletedUser);

        log.info("deleteTest for User completed");
    }


}

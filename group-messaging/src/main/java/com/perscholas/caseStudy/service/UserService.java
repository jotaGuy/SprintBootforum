package com.perscholas.caseStudy.service;

import com.perscholas.caseStudy.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createNewUser(RegisterUserFormBean form) {
        User users = new User();

        users.setUsername(form.getUsername().toLowerCase());
        users.setEmail(form.getEmail().toLowerCase());

        String encoded = passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: " + encoded);
        users.setPassword(encoded);

        return userDao.save(users);
    }

    public User getUserByUsername(String username) {
        return userDao.findByUsernameIgnoreCase(username);
    }

    public boolean authenticateUser(String username, String password) {
        User user = getUserByUsername(username);

        if (user != null) {
            // Check if the provided password matches the stored hashed password
            return passwordEncoder.matches(password, user.getPassword());
        }

        return false; // User does not exist
    }
}

package com.perscholas.caseStudy.service;

import com.perscholas.caseStudy.enity.Users;
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


    public Users createNewUser(RegisterUserFormBean form) {
        Users users = new Users();

        users.setEmail(form.getEmail().toLowerCase());

        String encoded = passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: " + encoded);
        users.setPassword(encoded);

        return userDao.save(users);
    }

}

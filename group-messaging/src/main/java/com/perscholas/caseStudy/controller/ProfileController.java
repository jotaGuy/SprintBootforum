package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProfileController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/profile/profile")
    public ModelAndView profile() {
        // Get the Authentication object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Retrieve the current user's username
        String currentUsername = authentication.getName();

        log.info("current UserName: " + currentUsername);

        // Now, you can use the username to fetch the user details from the repository
        User currentUser = userDAO.findByEmailIgnoreCase(currentUsername);

        // Pass the user details to the view
        ModelAndView response = new ModelAndView("profile/profile");
        response.addObject("currentUser", currentUser);

        log.info("current User: " + currentUser);

        return response;
    }
}

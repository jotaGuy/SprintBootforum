// AdminController.java
package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.dao.CommentDAO;
import com.perscholas.caseStudy.database.dao.PostDAO;
import com.perscholas.caseStudy.database.dao.TopicsDAO;
import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.database.entity.User;
import com.perscholas.caseStudy.dto.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserDAO userDAO;
    private final TopicsDAO topicsDAO;
    private final PostDAO postDAO;
    private final CommentDAO commentDAO;

    @Autowired
    public AdminController(UserDAO userDAO, TopicsDAO topicsDAO, PostDAO postDAO, CommentDAO commentDAO) {
        this.userDAO = userDAO;
        this.topicsDAO = topicsDAO;
        this.postDAO = postDAO;
        this.commentDAO = commentDAO;
    }

    @GetMapping("/admin/index")
    public ModelAndView index() {
        log.debug("Admin index page requested");
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/index");

        List<UserInfoDTO> userInfos = new ArrayList<>();

        List<User> users = userDAO.findAll();
        users.forEach(user -> {
            int numTopics = topicsDAO.findByUserId(user.getId()).size();
            int numPosts = postDAO.findByUserId(user.getId()).size();
            int numComments = commentDAO.findByUserId(user.getId()).size();

            UserInfoDTO userInfoDTO = new UserInfoDTO(user.getUsername(), user.getEmail(), numTopics, numPosts, numComments);
            userInfos.add(userInfoDTO);
        });

        response.addObject("userInfos", userInfos);

        return response;
    }
}

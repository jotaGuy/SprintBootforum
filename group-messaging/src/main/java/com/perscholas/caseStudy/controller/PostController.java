package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.dao.PostDAO;
import com.perscholas.caseStudy.database.dao.TopicsDAO;
import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.database.entity.Posts;
import com.perscholas.caseStudy.database.entity.Topics;
import com.perscholas.caseStudy.database.entity.User;
import com.perscholas.caseStudy.formbean.CreatePostFormBean;
import com.perscholas.caseStudy.service.PostService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class PostController {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PostService postService;

    @Autowired
    private TopicsDAO topicsDAO;

    @GetMapping("/post/post")
    public ModelAndView displayMessages(@RequestParam(required = true) String topic) {

        ModelAndView response = new ModelAndView("post/post");

        List<Posts> posts = postDAO.findByTopic(topic);

        Topics topics = topicsDAO.findByTopic(topic);

        List<String> usernames = new ArrayList<>();

        for (Posts post : posts) {
            User userId = post.getUserId();
            User user = userDAO.findById(userId.getId());
            if (user != null) {
                usernames.add(user.getUsername());
            } else {
                // Handle the case where user is not found for the given user_id
                usernames.add("Unknown User");
            }
        }

        response.addObject("posts", posts);
        response.addObject("usernames", usernames);
        log.info("usernames" + usernames);
        response.addObject("topics", topics);
        return response;
    }

    @GetMapping("/post/createPost")
    public ModelAndView createMessages(@RequestParam(required = true) String topic) {

        return new ModelAndView("post/createPost");
    }

    @PostMapping("/post/submitPost")
    public ModelAndView submitPost(@ModelAttribute("createPostFormBean") @Valid CreatePostFormBean form, BindingResult result) {
        ModelAndView response = new ModelAndView("post/createTopic");

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                log.error("Validation error in field '{}': {}", error.getField(), error.getDefaultMessage());
            }
            response.addObject("validationErrors", result.getFieldErrors());
            return response;
        }




        postService.createPost(form);

        String topic = form.getTopic();
        response.setViewName("redirect:/post/post?topic=" + URLEncoder.encode(String.valueOf(topic), StandardCharsets.UTF_8));

        return response;
    }
}

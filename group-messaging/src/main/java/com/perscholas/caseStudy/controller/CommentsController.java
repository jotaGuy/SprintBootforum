package com.perscholas.caseStudy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perscholas.caseStudy.database.dao.CommentDAO;
import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.database.entity.Comments;
import com.perscholas.caseStudy.formbean.CreateCommentFormBean;
import com.perscholas.caseStudy.service.CommentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class CommentsController {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/comments")
    public ModelAndView displayMessages(@RequestParam(required = false) Integer postId) {
        ModelAndView response = new ModelAndView("comments/comments");

        List<Comments> comments = commentDAO.findByPostId(postId);

        Collections.reverse(comments);

        response.addObject("comments", comments);

        return response;
    }


    @PostMapping("/comments/submitComment")
    public ModelAndView submitComment(
            @RequestParam(required = true) Integer postId,
            @ModelAttribute("createCommentFormBean") @Valid CreateCommentFormBean form,
            BindingResult result) {

        ModelAndView response = new ModelAndView("redirect:/comments/comments");

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                log.error("Validation error in field '{}': {}", error.getField(), error.getDefaultMessage());
            }
            response.addObject("validationErrors", result.getFieldErrors());
            // Include the postId parameter in the redirect URL
            response.addObject("postId", postId);
            return response;
        }

        commentService.createComment(form);

        // Include the postId parameter in the redirect URL
        response.addObject("postId", postId);
        return response;
    }

}

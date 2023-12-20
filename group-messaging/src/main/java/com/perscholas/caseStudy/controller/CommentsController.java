package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.dao.CommentDAO;
import com.perscholas.caseStudy.database.dao.PostDAO;
import com.perscholas.caseStudy.database.entity.Comments;
import com.perscholas.caseStudy.database.entity.Posts;
import com.perscholas.caseStudy.formbean.CreateCommentFormBean;
import com.perscholas.caseStudy.formbean.CreatePostFormBean;
import com.perscholas.caseStudy.service.PostService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CommentsController {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private PostService postService;
    @GetMapping("/comments/comments")
    public ModelAndView displayMessages(@RequestParam(required = true) Integer postId) {
        ModelAndView response = new ModelAndView("comments/comments");

        List<Comments> messages = commentDAO.findByPostId(postId);

        response.addObject("messages", messages);
        return response;
    }

    @GetMapping("/comments/addComment")
    public ModelAndView createComment(@RequestParam(required = true) Integer postId) {
        ModelAndView response = new ModelAndView("comments/addComment");
        return response;
    }

    @PostMapping("/comments/submitComment")
    public ModelAndView submitComment(@ModelAttribute("createPostFormBean") @Valid CreateCommentFormBean form, BindingResult result) {
        ModelAndView response = new ModelAndView("comments/addComment");

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                log.error("Validation error in field '{}': {}", error.getField(), error.getDefaultMessage());
            }
            response.addObject("validationErrors", result.getFieldErrors());
            return response;
        }

        response.setViewName("redirect:/post/post");
        return response;
    }

}

package com.perscholas.caseStudy.service;

import com.perscholas.caseStudy.database.dao.PostDAO;
import com.perscholas.caseStudy.database.dao.TopicsDAO;
import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.database.entity.Posts;
import com.perscholas.caseStudy.database.entity.Topics;
import com.perscholas.caseStudy.database.entity.User;
import com.perscholas.caseStudy.formbean.CreatePostFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostService {

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TopicsDAO topicsDAO;

    public Posts createPost(CreatePostFormBean form) {
        Posts post = new Posts();

        User user = userDAO.findByEmailIgnoreCase(form.getUser());
        Topics topic = topicsDAO.findByTopic(form.getTopic());

        post.setUserId(user);
        post.setTopic(form.getTopic());
        post.setTitle(form.getTitle());
        post.setMessage(form.getMessage());
        return postDAO.save(post);
    }

}

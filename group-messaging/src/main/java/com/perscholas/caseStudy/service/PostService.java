package com.perscholas.caseStudy.service;

import com.perscholas.caseStudy.database.dao.PostDAO;
import com.perscholas.caseStudy.database.entity.Posts;
import com.perscholas.caseStudy.formbean.CreatePostFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostService {

    @Autowired
    private PostDAO postDAO;

    public Posts createPost(CreatePostFormBean form) {
        Posts post = new Posts();
        post.setTopic(form.getTopic());
        post.setEmail(form.getAuthenticatedUserName());
        post.setTitle(form.getTitle());
        post.setMessage(form.getMessage());
        return postDAO.save(post);
    }

}

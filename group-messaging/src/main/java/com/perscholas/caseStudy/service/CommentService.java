package com.perscholas.caseStudy.service;

import com.perscholas.caseStudy.database.dao.CommentDAO;
import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.database.entity.Comments;
import com.perscholas.caseStudy.database.entity.User;
import com.perscholas.caseStudy.formbean.CreateCommentFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private UserDAO userDAO;

    public Comments createComment(CreateCommentFormBean form) {
        Comments comment = new Comments();

        User user = userDAO.findByEmailIgnoreCase(form.getUser());

        comment.setUserId(user);
        comment.setComment(form.getComment());
        comment.setPostId(form.getPostId());
        return commentDAO.save(comment);
    }
}

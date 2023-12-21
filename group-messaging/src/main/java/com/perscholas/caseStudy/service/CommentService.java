package com.perscholas.caseStudy.service;

import com.perscholas.caseStudy.database.dao.CommentDAO;
import com.perscholas.caseStudy.database.entity.Comments;
import com.perscholas.caseStudy.formbean.CreateCommentFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private CommentDAO commentDAO;

    public Comments createComment(CreateCommentFormBean form) {
        Comments comment = new Comments();
        comment.setUserEmail(form.getUser());
        comment.setComment(form.getComment());
        comment.setPostId(form.getPostId());
        return commentDAO.save(comment);
    }
}

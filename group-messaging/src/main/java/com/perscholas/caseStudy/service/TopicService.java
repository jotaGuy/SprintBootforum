package com.perscholas.caseStudy.service;

import com.perscholas.caseStudy.database.dao.TopicsDAO;
import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.database.entity.Topics;
import com.perscholas.caseStudy.database.entity.User;
import com.perscholas.caseStudy.formbean.CreateTopicFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TopicService {

    @Autowired
    private TopicsDAO topicsDAO;

    @Autowired
    private UserDAO userDAO;

    public Topics createTopic(CreateTopicFormBean form) {
        Topics topic = new Topics();

        User user = userDAO.findByEmailIgnoreCase(form.getUser());

        topic.setUserId(user);
        topic.setTopic(form.getTopic());
        topic.setDescription(form.getDescription());

        return topicsDAO.save(topic);
    }
}

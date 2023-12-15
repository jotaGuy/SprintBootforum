package com.perscholas.caseStudy.service;

import com.perscholas.caseStudy.database.dao.TopicsDAO;
import com.perscholas.caseStudy.database.entity.Topics;
import com.perscholas.caseStudy.formbean.CreateTopicFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicsDAO topicsDAO;

    public Topics createTopic(CreateTopicFormBean form) {
        Topics topic = new Topics();
        topic.setTopic(form.getTopic());
        topic.setDescription(form.getDescription());
        return topicsDAO.save(topic);
    }
}

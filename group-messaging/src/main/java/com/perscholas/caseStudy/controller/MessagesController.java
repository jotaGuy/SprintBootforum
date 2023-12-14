package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.dao.MessagesDAO;
import com.perscholas.caseStudy.database.entity.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MessagesController {

    @Autowired
    private MessagesDAO messagesDAO;

    @GetMapping("/topicMessages/displayMessages")
    public ModelAndView displayMessages(@RequestParam(required = true) String topic) {
        System.out.println("Signinggg" + topic);

        ModelAndView response = new ModelAndView("topicMessages/displayMessages");


        List<Messages> messages = messagesDAO.findByTopic(topic);

        response.addObject("messages", messages);
        return response;
    }
}

package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.dao.TopicsDAO;
import com.perscholas.caseStudy.database.entity.Topics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    private TopicsDAO topicsDAO;

    @GetMapping("/")
    public ModelAndView index() {
        System.out.println("Signing");

        // Use findAll() to get all topics
        List<Topics> topics = topicsDAO.findAll();

        ModelAndView response = new ModelAndView("index");
        response.addObject("topics", topics); // Update the variable name

        return response;
    }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }
}

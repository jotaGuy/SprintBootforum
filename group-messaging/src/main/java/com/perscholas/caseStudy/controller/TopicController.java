package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.dao.TopicsDAO;
import com.perscholas.caseStudy.database.entity.Topics;
import com.perscholas.caseStudy.formbean.CreateTopicFormBean;
import com.perscholas.caseStudy.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class TopicController {

    @Autowired
    private TopicsDAO topicsDAO;

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics/topics")
    public ModelAndView searchTopics(Model model) {
        List<Topics> topics = topicsDAO.findAll();

        ModelAndView response = new ModelAndView("topics/topics");
        response.addObject("topics", topics); // Update the variable name

        return response;
    }

    @GetMapping("/topics/createTopic")
    public ModelAndView topic() {
        ModelAndView response = new ModelAndView();
        response.setViewName("topics/createTopic");
        return  response;
    }

    @PostMapping("/topics/submitTopic")
    public ModelAndView createTopicSubmit(
            @ModelAttribute("createTopicFormBean") @Valid CreateTopicFormBean form,
            BindingResult result
    ) {

        ModelAndView response = new ModelAndView("topics/createTopic");

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                log.error("Validation error in field '{}': {}", error.getField(), error.getDefaultMessage());
            }
            response.addObject("validationErrors", result.getFieldErrors());
            List<Topics> topics = topicsDAO.findAll();
            response.addObject("topics", topics);
            response.setViewName("topics/createTopic");
            return response;
        }

        topicService.createTopic(form);
        response.setViewName("redirect:/topics/topics");
        return response;
    }
}

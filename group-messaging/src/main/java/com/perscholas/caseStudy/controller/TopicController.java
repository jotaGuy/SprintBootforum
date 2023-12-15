package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.dao.TopicsDAO;
import com.perscholas.caseStudy.database.entity.Topics;
import com.perscholas.caseStudy.formbean.CreateTopicFormBean;
import com.perscholas.caseStudy.service.TopicService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class TopicController {

    @Autowired
    private TopicsDAO topicsDAO;

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics/createTopic")
    public ModelAndView createTopicForm(Model model) {
        List<Topics> topics = topicsDAO.findAll();
        model.addAttribute("topics", topics);
        model.addAttribute("createTopicFormBean", new CreateTopicFormBean());
        return new ModelAndView("topics/createTopic");
    }

    @PostMapping("/topics/createTopic")
    public String createTopicSubmit(
            @ModelAttribute("createTopicFormBean") @Valid CreateTopicFormBean form,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            List<Topics> topics = topicsDAO.findAll();
            model.addAttribute("topics", topics);
            return "topics/createTopic";
        }

        topicService.createTopic(form);
        return "redirect:/";
    }
}

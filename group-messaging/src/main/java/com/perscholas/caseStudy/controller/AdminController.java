
package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.enity.Users;
import com.perscholas.caseStudy.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import com.perscholas.caseStudy.database.entity.User;
import com.perscholas.caseStudy.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @GetMapping("/admin/index")
    public ModelAndView index() {
        log.debug("Admin index page requested");
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/index");
        return response;
    }


}
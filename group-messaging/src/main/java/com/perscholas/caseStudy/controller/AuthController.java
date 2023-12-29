package com.perscholas.caseStudy.controller;

import com.perscholas.caseStudy.database.entity.User;
import com.perscholas.caseStudy.security.AuthenticatedUserService;
import com.perscholas.caseStudy.service.UserService;
import com.perscholas.caseStudy.formbean.RegisterUserFormBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/auth/login")
    public ModelAndView login(@RequestParam(name = "error", required = false) String error) {
        ModelAndView response = new ModelAndView("auth/login");

        log.info("trying to log in");

        // Check if there is an error attribute and add it to the model
        if (error != null && !error.isEmpty()) {
            log.info("Error: " + error);
            response.addObject("error", "Invalid username or password");
        }

        log.info("No Error");

        return response;
    }


    @GetMapping("/auth/register")
    public ModelAndView register() {
        ModelAndView response = new ModelAndView();
        response.setViewName("auth/register");
        return response;
    }

    @PostMapping("/auth/registerSubmit")
    public ModelAndView registerSubmit(@Valid RegisterUserFormBean form, BindingResult bindingResult, HttpSession session) {
        log.info("Form Submitted!");

        ModelAndView response = new ModelAndView("auth/register");

        if (bindingResult.hasErrors()) {
            log.info("######################### In register user - has errors #########################");
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In register user - no error found #########################");

        // Check if the user already exists
        if (userService.userExists(form.getEmail())) {
            log.info("User already exists!");
            response.addObject("form", form);
            response.addObject("userExistsError", "User with the provided username or email already exists.");
            return response;
        }

        // Log the values
        log.info("Username: " + form.getUsername());
        log.info("Email: " + form.getEmail());
        log.info("Password: " + form.getPassword());

        User u = userService.createNewUser(form);

        authenticatedUserService.authenticateNewUser(session, u.getEmail(), form.getPassword());

        // Redirect to the home page after successful registration
        response.setViewName("redirect:/");
        return response;
    }



    @GetMapping("/auth/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        // Invalidate the current session
        session.invalidate();

        // Perform any additional logout logic if needed

        ModelAndView modelAndView = new ModelAndView("redirect:/auth/login");
        return modelAndView;
    }
}

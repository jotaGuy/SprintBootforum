package com.perscholas.caseStudy.formbean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CreateMessageFormBean {

    @Email(message = "Email must be a valid email address")
    private String email;

    @Length(min=8, message = "Password must be at least 8 characters long")
    private String topic;

    @NotEmpty(message = "Confirm Password cannot be empty")
    @Length(min=10, max=300, message = "10 character minimum")
    private String message;
}

package com.perscholas.caseStudy.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreatePostFormBean {

    @NotEmpty(message = "Must add a title to post")
    private String authenticatedUserName;

    @NotEmpty(message = "Description cannot be empty")
    private String topic;

    @NotEmpty(message = "Must add a title to post")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    private String message;
}

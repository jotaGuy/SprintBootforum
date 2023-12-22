package com.perscholas.caseStudy.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateTopicFormBean {

    @NotEmpty(message = "Must add a title to post")
    private String user;

    @NotEmpty(message = "Must add a Topic")
    private String topic;

    @Length(min=50, max=500, message = "Description must be at least 100 - 500 characters long")
    @NotEmpty(message = "Description cannot be empty")
    private String description;

}

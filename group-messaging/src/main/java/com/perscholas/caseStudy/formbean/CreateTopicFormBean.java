package com.perscholas.caseStudy.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateTopicFormBean {

    @NotEmpty(message = "Must add a Topic")
    private String topic;

    @Length(min=100, message = "Description must be short and sweet!")
    @NotEmpty(message = "Description cannot be empty")
    private String description;

    // Getters and setters
}

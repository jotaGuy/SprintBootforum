package com.perscholas.caseStudy.formbean;

import com.perscholas.caseStudy.database.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreatePostFormBean {

    @NotEmpty(message = "Must be authenticated")
    private String user;

    @NotEmpty(message = "Description cannot be empty")
    private String topic;

    @NotEmpty(message = "Must add a title to post")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    private String message;
}

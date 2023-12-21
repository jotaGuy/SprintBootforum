package com.perscholas.caseStudy.formbean;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentFormBean {

    @NotNull(message = "Post ID cannot be null")
    private Integer postId;

    @NotEmpty(message = "Must be authenticated")
    private String user;

    @NotEmpty(message = "Comment cannot be empty")
    private String comment;

}

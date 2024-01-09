package com.perscholas.caseStudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDTO {
    private String username;
    private String email;
    private int numTopics;
    private int numPosts;
    private int numComments;
}

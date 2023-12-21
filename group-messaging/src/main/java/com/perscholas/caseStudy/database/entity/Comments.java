package com.perscholas.caseStudy.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user")
    private String userEmail;

    @Column(name = "comment")
    private String comment;

    // idea of the message the comment is for
    @Column(name = "postId", nullable = false)
    private Integer postId;
}

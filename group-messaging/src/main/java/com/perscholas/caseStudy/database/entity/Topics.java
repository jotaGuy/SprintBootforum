package com.perscholas.caseStudy.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "topics")
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user")
    private String user;

    @Column(name = "topic")
    private String topic;

    @Column(name = "description")
    private String description;

    // Constructors, getters, and setters can be added as needed
}

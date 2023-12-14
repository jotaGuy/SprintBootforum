package com.perscholas.caseStudy.enity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // Add the @Entity annotation to indicate that this class is a JPA entity
public class Signup {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id; // Use Long as the ID type for better compatibility with databases

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}

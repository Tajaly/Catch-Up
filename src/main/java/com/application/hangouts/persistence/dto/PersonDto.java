package com.application.hangouts.persistence.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
/*
@Table("person")
public record PersonDto (@Id String email, String name, String bio) {}

 */


@Table("person")
public class PersonDto {
    @Id
    private String email;
    private String name;
    private String bio;

    // Constructors, getters, and setters
    public PersonDto(String email, String name, String bio) {
        this.email = email;
        this.name = name;
        this.bio = bio;
    }

    // Getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
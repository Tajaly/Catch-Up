package com.application.catchup.persistence.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("person")
public record PersonDto (@Id String username, String name, String bio) {}



/*
@Table("person")
public class PersonDto {
    @Id
    private String username;
    private String name;
    private String bio;

    // Constructors, getters, and setters
    public PersonDto(String username, String name, String bio) {
        this.username = username;
        this.name = name;
        this.bio = bio;
    }

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

 */
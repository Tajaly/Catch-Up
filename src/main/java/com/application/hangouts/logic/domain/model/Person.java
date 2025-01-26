package com.application.hangouts.logic.domain.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;


public class Person {

    private String username;

    private String name;

    private String bio;

    public Person(String username, String name, String bio) {
        this.username = username;
        this.name = name;
        this.bio = bio;
    }

    public Person(String username, String name) {
        this.username = username;
        this.name = name;
        this.bio = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return this.name;
    }



    @Override
    public String toString() {
        return "Person: " + this.name + " username:" + this.username + " bio: " +this.bio;
    }

}

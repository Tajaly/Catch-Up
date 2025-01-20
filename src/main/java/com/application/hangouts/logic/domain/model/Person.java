package com.application.hangouts.logic.domain.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;


public class Person {

    private String email;

    private String name;

    private String bio;

    public Person(String email, String name, String bio) {
        this.email = email;
        this.name = name;
        this.bio = bio;
    }

    public Person(String email, String name) {
        this.email = email;
        this.name = name;
        this.bio = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "Person: " + this.name + " email:" + this.email + " bio: " +this.bio;
    }

}

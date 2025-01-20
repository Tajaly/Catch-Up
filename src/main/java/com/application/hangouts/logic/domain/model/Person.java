package com.application.hangouts.logic.domain.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;


public class Person {




    //@Id
    private Integer id;


    private String name;


   // @PersistenceCreator
    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }


    public Person(String name) {
        this.name = name;
        this.id = null;

    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "User: " + this.id + " " + this.name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}

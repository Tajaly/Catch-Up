package com.application.hangouts.logic.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Circle {

    private Integer id;

    private String name;

    //email
    private String organizer;

    private Set<Person> groupMembers = new HashSet<>();

    public Circle(Integer id, String name, String organizer, Set<Person> groupMembers) {
        this.id = id;
        this.name = name;
        this.organizer = organizer;
        this.groupMembers = groupMembers;
    }

    public Circle(String name, String organizer, Set<Person> groupMembers) {
        this.name = name;
        this.organizer = organizer;
        this.groupMembers = groupMembers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Set<Person> groupMembers) {
        this.groupMembers = groupMembers;
    }

    @Override
    public String toString(){
        return "Circle: " + this.id + " " +this.name + " " + this.organizer + " " + this.groupMembers;
    }
}

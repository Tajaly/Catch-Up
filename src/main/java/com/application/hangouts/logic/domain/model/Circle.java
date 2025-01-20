package com.application.hangouts.logic.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.ArrayList;
import java.util.List;

public class Circle {

    //private Integer id;

    private String name;

    private List<Person> groupMembers = new ArrayList<>();


    public Circle(String name, List<Person> groupMembers) {
        this.name = name;
        this.groupMembers = groupMembers;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<Person> groupMembers) {
        this.groupMembers = groupMembers;
    }
}

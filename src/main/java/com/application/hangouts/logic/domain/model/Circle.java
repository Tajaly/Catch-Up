package com.application.hangouts.logic.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.ArrayList;
import java.util.List;

public class Circle {

    @Id
    private Integer id;
    private List<Person> groupMembers = new ArrayList<>();

    @PersistenceCreator
    public Circle(int id, List<Person> groupMembers) {
        this.id = id;
        this.groupMembers = groupMembers;

    }

    public Circle(List<Person> groupMembers) {
        this.id = null;
        this.groupMembers = groupMembers;
    }

    public Integer getId() {
        return id;
    }
}

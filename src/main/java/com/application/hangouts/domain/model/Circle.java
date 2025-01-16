package com.application.hangouts.domain.model;

import com.application.hangouts.domain.model.User;
import com.application.hangouts.domain.persistence.CircleRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.ArrayList;
import java.util.List;

public class Circle {

    @Id
    private Integer id;
    private List<User> groupMembers = new ArrayList<>();

    @PersistenceCreator
    public Circle(int id, List<User> groupMembers) {
        this.id = id;
        this.groupMembers = groupMembers;

    }

    public Circle(List<User> groupMembers) {
        this.id = null;
        this.groupMembers = groupMembers;
    }

    public Integer getId() {
        return id;
    }
}

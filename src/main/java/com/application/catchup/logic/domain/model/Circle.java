package com.application.catchup.logic.domain.model;

import com.application.catchup.persistence.dto.PersonDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Circle {

    private Integer id;

    private String name;

    //username
    private String organizer;

    private Set<String> member;

    private List<Hangout> hangouts;

    public void addMember(String person) {
        member.add(person);
    }


    public void addHangout(Hangout hangout){
        hangouts.add(hangout);
    }

    public Circle(Integer id, String name, String organizer, Set<String> member, List<Hangout> hangouts) {
        this.id = id;
        this.name = name;
        this.organizer = organizer;
        this.member = member;
        this.hangouts = hangouts;
    }

    public Circle(String name, String organizer) {
        this.name = name;
        this.organizer = organizer;
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

    public Set<String> getMember() {
        return member;
    }

    public void setMember(Set<String> member) {
        this.member = member;
    }

    public List<Hangout> getHangouts() {
        return hangouts;
    }

    public void setHangouts(List<Hangout> hangouts) {
        this.hangouts = hangouts;
    }

    @Override
    public String toString(){
        return "Circle: " + this.id + " " +this.name + " " + this.organizer ;
    }
}

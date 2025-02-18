package com.application.catchup.logic.domain.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Hangout {

    private Integer id;

    private String name;

    private String description;
    private String organizer;
    private Integer circle;
    private LocalDateTime start;

    //optional
    private LocalDateTime end;

    public Hangout(Integer id, String name, String description, String organizer, Integer circle, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.organizer = organizer;
        this.circle = circle;
        this.start = start;
        this.end = end;
    }

    public Hangout( String name, String description, String organizer, Integer circle, LocalDateTime start, LocalDateTime end) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.organizer = organizer;
        this.circle = circle;
        this.start = start;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Integer getCircle() {
        return circle;
    }

    public void setCircle(Integer circle) {
        this.circle = circle;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}

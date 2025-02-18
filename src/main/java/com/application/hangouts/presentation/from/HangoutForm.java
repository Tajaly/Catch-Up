package com.application.hangouts.presentation.from;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class HangoutForm {

    @NotBlank
    private String name;
    private String description;


    private Integer circle;


    //has to be in the future
    private LocalDateTime start;

    //optional has to be after start or null
    private LocalDateTime end;

    public HangoutForm(String name, String description, Integer circle, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.description = description;
        this.circle =circle;
        this.start = start;
        this.end = end;
    }

    public Integer getCircle() {
        return circle;
    }

    public void setCircle(Integer circle) {
        this.circle = circle;
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

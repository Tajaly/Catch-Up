package com.application.hangouts.presentation.from;

import jakarta.validation.constraints.NotBlank;

public class CircleForm {

    @NotBlank(message = "Name is required.")
    private String name;

    public CircleForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

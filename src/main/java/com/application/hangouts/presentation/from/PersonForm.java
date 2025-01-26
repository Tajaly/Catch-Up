package com.application.hangouts.presentation.from;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public class PersonForm {
    // PersonDto (@Id String username, String name, String bio)

    @NotBlank (message = "name required")
    private String name;

    private String bio;

    public PersonForm(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

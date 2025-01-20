package com.application.hangouts.presentation.from;

import jakarta.validation.constraints.NotBlank;

public class HangoutForm {

    //required

   // @NotBlank
    //private LocalDateTime start;

    //optional
    //private LocalDateTime end;

    @NotBlank
    private String title;
    private String description;


}

package com.application.hangouts.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome () {
        return "index";
    }


    //http://localhost:8080/circles
    @GetMapping("/circles")
    @ResponseStatus(HttpStatus.OK)
    public String getCirclesOverview () {
        return "circle/circles";
    }

    //http://localhost:8080/hangouts
    @GetMapping("/hangouts")
    @ResponseStatus(HttpStatus.OK)
    public String getUpcomingHangouts () {
        return "hangout/scheduled-hangouts";
    }


}

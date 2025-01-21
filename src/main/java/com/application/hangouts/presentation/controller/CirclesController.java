package com.application.hangouts.presentation.controller;

import com.application.hangouts.logic.ApplicationService;
import com.application.hangouts.logic.domain.services.CircleService;
import com.application.hangouts.presentation.from.CircleForm;
import com.application.hangouts.presentation.from.HangoutForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CirclesController {
    private final CircleService circleService;

    private final ApplicationService applicationService;

    public CirclesController(CircleService circleService, ApplicationService applicationService) {
        this.circleService = circleService;
        this.applicationService =applicationService;
    }



    //http://localhost:8080/circles/create-circle
    @GetMapping("/circles/create-circle")
    @ResponseStatus(HttpStatus.OK)
    public String getCreateCircle () {
        return "circle/createCircle";
    }

    @PostMapping("/circles/create-circle")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCircle(@Valid CircleForm circleForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "circle/createCircle";
        }
        //TODO wie kommt man an die email des erstellers?
        //applicationService.createCircle(email, name);
        //TODO Circle Overview Seite erstellen und dahin redirecten
        redirectAttributes.addFlashAttribute("circleForm", circleForm);
        System.out.println("funktioniert" + circleForm);

        return "redirect:/";

    }
}

package com.application.hangouts.presentation.controller;

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
public class HangoutController {

    @GetMapping("/create-hangout")
    @ResponseStatus(HttpStatus.OK)
    public String getCreateHangouts () {
        return "hangout/create-hangout";
    }

   // http://localhost:8080/create-hangout
    @PostMapping("/create-hangout")
    @ResponseStatus(HttpStatus.CREATED)
    public String createHangout(@Valid HangoutForm hangoutForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "hangout/create-hangout";
        }

        redirectAttributes.addFlashAttribute("hangoutForm", hangoutForm);
        System.out.println("funktioniert" + hangoutForm);

        return "redirect:/";


       // return "hangout/create-Hangout";
    }
}

package com.application.hangouts.presentation.controller;

import com.application.hangouts.logic.ApplicationService;
import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.logic.domain.services.CircleRepository;
import com.application.hangouts.logic.domain.services.CircleService;
import com.application.hangouts.logic.domain.services.PersonRepository;
import com.application.hangouts.logic.domain.services.PersonService;
import com.application.hangouts.presentation.from.CircleForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CirclesController {

    private final CircleRepository circleRepository;

    private final PersonRepository personRepository;

    private final ApplicationService applicationService;


    public CirclesController(CircleRepository circleRepository, PersonRepository personRepository, ApplicationService applicationService) {
        this.circleRepository = circleRepository;
        this.personRepository = personRepository;
        this.applicationService = applicationService;
    }


    //http://localhost:8080/circles/create-circle

    @GetMapping("/circles/create-circle")
    @ResponseStatus(HttpStatus.OK)
    public String getCreateCircle (Model model, CircleForm circleForm, OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        System.out.println(oAuth2AuthenticationToken.getPrincipal());



        model.addAttribute(circleForm);
        return "circle/create-circle";
    }




    @PostMapping("/circles/create-circle")
    public String createCircle(@Valid CircleForm circleForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        String username = oAuth2AuthenticationToken.getPrincipal().getAttribute("login");
        model.addAttribute("circleForm", circleForm);

        if (bindingResult.hasErrors()) {

            return "/circle/create-circle";
        }

        Circle circle = applicationService.createCircle(username, circleForm.getName());



        redirectAttributes.addAttribute("id", circle.getId());
        return  "redirect:/circle/" + circleForm.getName() ;

    }


    //todo prüfen ob dieser user berechtigung hat diesen circle zu sehen
    @GetMapping("/circle/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String getCircleOverview (Model model,Integer id, String name) {
       // check(user, circleid)
        Circle circle = circleRepository.findById(id);
        model.addAttribute("name", circle.getName());
        return "/circle/circle";
    }

}

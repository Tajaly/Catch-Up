package com.application.catchup.presentation.controller;

import com.application.catchup.logic.ApplicationService;
import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.logic.domain.services.CircleRepository;
import com.application.catchup.logic.domain.services.PersonRepository;
import com.application.catchup.presentation.from.CircleForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String getCreateCircle (Model model, CircleForm circleForm) {



        model.addAttribute(circleForm);
        return "circle/create-circle";
    }




    @PostMapping("/circles/create-circle")
    public String createCircle(@Valid CircleForm circleForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        String username = applicationService.getUsernameByOauth(oAuth2AuthenticationToken);
        model.addAttribute("circleForm", circleForm);

        if (bindingResult.hasErrors()) {

            return "/circle/create-circle";
        }

        Circle circle = applicationService.createCircle(username, circleForm.getName());

        redirectAttributes.addAttribute("id", circle.getId());
        return  "redirect:/circle/" + circleForm.getName() ;

    }

    @GetMapping("/circle/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String getCircleOverview (Model model,Integer id, @PathVariable String name, OAuth2AuthenticationToken oAuth2AuthenticationToken) {

    if (applicationService.isPersonCircleMember(oAuth2AuthenticationToken, id)) {
        Circle circle = circleRepository.findById(id);
        model.addAttribute("name", name);
        return "/circle/circle";
    }

    return "redirect:/";

    }

}

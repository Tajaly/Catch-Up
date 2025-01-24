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

    //todo add user data and rm testperson
    //it is needed bc the person must exist to create a new circle
    private final static Person testPerson = new Person("testemail@test.de", "Isa");

    public CirclesController(CircleRepository circleRepository, PersonRepository personRepository, ApplicationService applicationService) {
        this.circleRepository = circleRepository;
        this.personRepository = personRepository;
        this.applicationService = applicationService;
    }


    //http://localhost:8080/circles/create-circle

    @GetMapping("/circles/create-circle")
    @ResponseStatus(HttpStatus.OK)
    public String getCreateCircle (Model model, CircleForm circleForm) {
        //todo rm later
       // personService.saveNewPerson(testPerson);


        model.addAttribute(circleForm);
        return "circle/create-circle";
    }




    @PostMapping("/circles/create-circle")
    public String createCircle(@Valid CircleForm circleForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("circleForm", circleForm);

        if (bindingResult.hasErrors()) {

            return "/circle/create-circle";
        }
        //TODO add email of the creator
        Circle circle = applicationService.createCircle("testemail@test.de", circleForm.getName());


        //TODO Circle Overview Seite erstellen und dahin redirecten
        redirectAttributes.addFlashAttribute("id", circle.getId());
        String url = "redirect:/circle/" + circleForm.getName() ;
        return url;

    }



    //circle aus der db holen und anzeigen
    //todo prüfen ob dieser user berechtigung hat diesen circle zu sehen
    @GetMapping("/circle/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String getCircleOverview (Model model,Integer id, @PathVariable("name") String name) {

        model.addAttribute("name", name);
        return "/circle/circle";
    }

}

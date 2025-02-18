package com.application.hangouts.presentation.controller;

import com.application.hangouts.logic.ApplicationService;
import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.logic.domain.services.PersonRepository;
import com.application.hangouts.presentation.from.PersonForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.Set;

@Controller
public class HomeController {

    private final PersonRepository personRepository;

    private final ApplicationService applicationService;

    public HomeController(PersonRepository personRepository, ApplicationService applicationService) {
        this.personRepository = personRepository;
        this.applicationService = applicationService;
    }

//TODO navbar


    @GetMapping("/")
    public String getHome (Model model, PersonForm personForm,   OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        String username = oAuth2AuthenticationToken.getPrincipal().getAttribute("login");
       // System.out.println(oAuth2AuthenticationToken);
        Optional<Person> person = personRepository.findPersonByUsername(username);
        if(person.isEmpty()) {
            model.addAttribute("personForm", personForm);
            return "user/create-user";
            //personRepository.saveNewPerson(new Person(username, username));
        };
        model.addAttribute("username", username);
        return "index";
    }

    //TODO (mid) profile anderer besuchen
    @GetMapping("/profile/{username}")
    public String getProfile (Model model, @PathVariable String username,
                              OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        /*
        if (applicationService.isUserProfileOwner(oAuth2AuthenticationToken, username)) {
        //TODO: (low prio) angaben editieren funktion

        }

         */
        System.out.println(username);

        Person person = personRepository.findPersonByUsername(username).get();
        model.addAttribute("person", person);

        return "/user/user";

    }

    @PostMapping("/create-user")
    public String createUser(@Valid PersonForm personForm, BindingResult bindingResult, Model model,
                             RedirectAttributes redirectAttributes, OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        model.addAttribute("personForm", personForm);

        if (bindingResult.hasErrors()) {
            return "user/create-user";
        }

        applicationService.createUser(personForm, oAuth2AuthenticationToken);


        return  "redirect:/" ;

    }


    //http://localhost:8080/circles
    @GetMapping("/circles")
    @ResponseStatus(HttpStatus.OK)
    public String getCirclesOverview (Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        String username = applicationService.getUsernameByOauth(oAuth2AuthenticationToken);
        Set<Circle> set = applicationService.findCirclesByPerson(username);
        model.addAttribute("circles", set);
        return "circle/my-circles";
    }

    //http://localhost:8080/hangouts
    @GetMapping("/hangouts")
    @ResponseStatus(HttpStatus.OK)
    public String getUpcomingHangouts () {
        return "hangout/scheduled-hangouts";
    }


}

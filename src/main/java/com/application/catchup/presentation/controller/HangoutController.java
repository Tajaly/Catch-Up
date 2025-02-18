package com.application.catchup.presentation.controller;

import com.application.catchup.logic.ApplicationService;
import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.logic.domain.model.Hangout;
import com.application.catchup.logic.domain.services.CircleRepository;
import com.application.catchup.logic.domain.services.HangoutRepository;
import com.application.catchup.presentation.from.HangoutForm;
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

import java.util.Set;

@Controller
public class HangoutController {

    private final ApplicationService applicationService;
    private final HangoutRepository hangoutRepository;
    private final CircleRepository circleRepository;



    public HangoutController(ApplicationService applicationService, HangoutRepository hangoutRepository, CircleRepository circleRepository) {
        this.applicationService = applicationService;
        this.hangoutRepository = hangoutRepository;
        this.circleRepository = circleRepository;
    }

    @GetMapping("hangouts/create-hangout")
    @ResponseStatus(HttpStatus.OK)
    public String getCreateHangouts (Model model, HangoutForm hangoutForm, OAuth2AuthenticationToken oAuth2AuthenticationToken) {

        String username = applicationService.getUsernameByOauth(oAuth2AuthenticationToken);
        Set<Circle> set = applicationService.findCirclesByPerson(username);
        model.addAttribute("circles", set);
        model.addAttribute(hangoutForm);
        return "hangout/create-hangout";
    }

   // http://localhost:8080/hangouts/create-hangout
    @PostMapping("hangouts/create-hangout")
    public String createHangout(@Valid HangoutForm hangoutForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        model.addAttribute("hangoutForm", hangoutForm);
        if (bindingResult.hasErrors()) {
            return "hangout/create-hangout";
        }

        Hangout hangout = applicationService.createHangout(hangoutForm, oAuth2AuthenticationToken);


        redirectAttributes.addAttribute("id", hangout.getId());

        String circleName = circleRepository.findById(hangout.getCircle()).getName();

        return "redirect:/hangout/" + circleName + "/" + hangout.getName() ;


    }

    @GetMapping("/hangout/{circleName}/{hangoutName}")
    @ResponseStatus(HttpStatus.OK)
    public String getHangoutOverview (Model model, Integer id, @PathVariable String circleName, @PathVariable String hangoutName, OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        Hangout hangout = hangoutRepository.findById(id);
        if (applicationService.isPersonCircleMember(oAuth2AuthenticationToken, hangout.getCircle())) {

            //TODO Hangout page
            //model.addAttribute("hangout", hangout);

            return "/hangout/hangout";
        }

        return "redirect:/";

    }
}

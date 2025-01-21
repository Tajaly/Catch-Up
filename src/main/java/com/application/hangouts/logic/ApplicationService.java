package com.application.hangouts.logic;

import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.logic.domain.services.CircleService;
import com.application.hangouts.logic.domain.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ApplicationService {
    private CircleService circleService;
    private PersonService personService;

    public ApplicationService(CircleService circleService, PersonService personService) {
        this.circleService = circleService;
        this.personService = personService;
    }


    public void createCircle(String email, String name) {

        Integer circleId = circleService.createCircle(name, email);

        personService.addMemberToCircle(circleId, email);
    }

    /*
    public ceatePerson()

    //circle in db and organizeer in circle member db
    public createCircle()

    public sendRequestToJoinCircle()

    public addPersonToCircle()

    //werden als Set<circle ids> returned
        findCirclesByPerson

     */


}

package com.application.hangouts.logic;

import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.logic.domain.services.CircleRepository;
import com.application.hangouts.logic.domain.services.CircleService;
import com.application.hangouts.logic.domain.services.PersonRepository;
import com.application.hangouts.logic.domain.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ApplicationService {
 //   private CircleService circleService;
   // private PersonService personService;

    private CircleRepository circleRepository;

    private PersonRepository personRepository;

    public ApplicationService(CircleRepository circleRepository, PersonRepository personRepository) {
        this.circleRepository = circleRepository;
        this.personRepository = personRepository;
    }

    public Circle createCircle(String email, String name) {

        Circle circle = circleRepository.save(new Circle(name, email));

        personRepository.addMemberToCircle(circle.getId(), email);

        return circle;
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

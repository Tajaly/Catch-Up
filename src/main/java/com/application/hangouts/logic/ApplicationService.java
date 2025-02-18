package com.application.hangouts.logic;

import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.logic.domain.model.Hangout;
import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.logic.domain.services.CircleRepository;
import com.application.hangouts.logic.domain.services.HangoutRepository;
import com.application.hangouts.logic.domain.services.PersonRepository;
import com.application.hangouts.presentation.from.HangoutForm;
import com.application.hangouts.presentation.from.PersonForm;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
 //   private CircleService circleService;
   // private PersonService personService;

    private CircleRepository circleRepository;

    private PersonRepository personRepository;

    private HangoutRepository hangoutRepository;

    public ApplicationService(CircleRepository circleRepository, PersonRepository personRepository, HangoutRepository hangoutRepository) {
        this.circleRepository = circleRepository;
        this.personRepository = personRepository;
        this.hangoutRepository = hangoutRepository;
    }

    public Circle createCircle(String username, String name) {

        Circle circle = circleRepository.save(new Circle(name, username));

        personRepository.addMemberToCircle(circle.getId(), username);

        return circle;
    }

    public String getUsernameByOauth(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return oAuth2AuthenticationToken.getPrincipal().getAttribute("login");
    }

    public Optional<Person> getPersonByOauth(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return personRepository.findPersonByUsername(getUsernameByOauth(oAuth2AuthenticationToken));
    }


    public boolean isPersonCircleMember(OAuth2AuthenticationToken oAuth2AuthenticationToken, Integer circleId) {
        String username = getUsernameByOauth(oAuth2AuthenticationToken);
        Set<Integer> set = personRepository.findCircleIdsByPerson(username);
        return set.contains(circleId);
    }

    public Set<Circle> findCirclesByPerson (String username) {
        return personRepository.findCircleIdsByPerson(username).stream().map(circleRepository ::findById).collect(Collectors.toSet());
    }

    public Person createUser (PersonForm personForm, OAuth2AuthenticationToken auth) {
        String username = getUsernameByOauth(auth);
        Person person = new Person(username, personForm.getName());
        if (!personForm.getBio().isBlank()) {
            person.setBio(personForm.getBio());
        }
         personRepository.saveNewPerson(person);
         return person;
    }

    public Hangout createHangout(HangoutForm hangoutForm, OAuth2AuthenticationToken auth) {
        String username = getUsernameByOauth(auth);
        Hangout saveHangout = new Hangout(hangoutForm.getName(), hangoutForm.getDescription(), username, hangoutForm.getCircle(), hangoutForm.getStart(), hangoutForm.getEnd());
        return hangoutRepository.save(saveHangout);
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

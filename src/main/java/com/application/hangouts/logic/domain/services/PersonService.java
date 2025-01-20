package com.application.hangouts.logic.domain.services;

import com.application.hangouts.logic.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    PersonRepository personRepository;




    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Optional<Person> findPersonByName(String name) {
        return personRepository.findPersonByName(name);
    };
}

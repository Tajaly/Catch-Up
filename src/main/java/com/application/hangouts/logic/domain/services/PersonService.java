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

    public void addMemberToCircle(Integer id, String username){
        personRepository.addMemberToCircle(id, username);
    }

    public void saveNewPerson(Person person) {
        personRepository.saveNewPerson(person);
    }

    /*
    public Optional<Person> findPersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    };

     */
}

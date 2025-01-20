package com.application.hangouts.logic.domain.services;

import com.application.hangouts.logic.domain.model.Person;

import java.util.List;
import java.util.Optional;


public interface PersonRepository {
    Optional<Person> findPersonByEmail(String email);
    //Person save(Person person);

    Integer saveNewPerson(Person person);
    void deleteByEmail(String email);

    List<Person> findAll();

}

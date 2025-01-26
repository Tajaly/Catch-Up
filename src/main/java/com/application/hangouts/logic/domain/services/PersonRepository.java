package com.application.hangouts.logic.domain.services;

import com.application.hangouts.logic.domain.model.Person;

import java.util.List;
import java.util.Optional;


public interface PersonRepository {
    Optional<Person> findPersonByUsername(String username);
    //Person save(Person person);

    Integer saveNewPerson(Person person);
    void deleteByUsername(String username);

    List<Person> findAll();

    void addMemberToCircle(Integer id, String username);

}

package com.application.hangouts.logic.domain.services;

import com.application.hangouts.logic.domain.model.Person;

import java.util.Optional;


public interface PersonRepository {
    public Optional<Person> findPersonByName(String name);
    Person save(Person person);
    void deletePersonByName(String name);

}

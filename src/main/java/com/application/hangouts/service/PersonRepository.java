package com.application.hangouts.service;

import com.application.hangouts.domain.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PersonRepository {
    public Optional<Person> findPersonByName(String name);

}

package com.application.catchup.logic.domain.services;

import com.application.catchup.logic.domain.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface PersonRepository {
    Optional<Person> findPersonByUsername(String username);

    Integer saveNewPerson(Person person);

    void deleteByUsername(String username);

    List<Person> findAll();

    void addMemberToCircle(Integer id, String username);

    Set<Integer> findCircleIdsByPerson(String username);
}

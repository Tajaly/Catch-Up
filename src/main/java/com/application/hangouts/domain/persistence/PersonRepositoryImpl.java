package com.application.hangouts.domain.persistence;

import com.application.hangouts.service.PersonRepository;
import com.application.hangouts.domain.model.Person;
import com.application.hangouts.domain.persistence.spring.data.SpringDataPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private SpringDataPersonRepository springDataPersonRepository;

    public PersonRepositoryImpl(SpringDataPersonRepository springDataPersonRepository) {
        this.springDataPersonRepository = springDataPersonRepository;
    }

    public Optional<Person> findPersonByName(String name) {
        return springDataPersonRepository.findPersonByName( name);
    }
}

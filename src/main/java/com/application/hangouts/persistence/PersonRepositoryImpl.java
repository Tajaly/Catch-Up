package com.application.hangouts.persistence;

import com.application.hangouts.persistence.dto.PersonDto;
import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.persistence.spring.data.SpringDataPersonRepository;
import com.application.hangouts.logic.domain.services.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private SpringDataPersonRepository springDataPersonRepository;

    //TODO findAll implementieren

    //Constructor injection
    public PersonRepositoryImpl(SpringDataPersonRepository springDataPersonRepository) {
        this.springDataPersonRepository = springDataPersonRepository;
    }

    public Optional<Person> findPersonByName(String name) {
        return springDataPersonRepository.findPersonByName(name).map(this::toPerson);
    }

    @Override
    public  Person save(Person person) {
        PersonDto personDto = toPersonDto(person);
        PersonDto savedPerson = springDataPersonRepository.save(personDto);
        return toPerson(savedPerson);
    }

    @Override
    public void deletePersonByName(String name) {
        springDataPersonRepository.deletePersonByName(name);
    }


    // Dto to domain
    private PersonDto toPersonDto(Person person) {
        return new PersonDto(person.getId(), person.getName());
    }

    private Person toPerson (PersonDto personDto) {
        return new Person( personDto.name(), personDto.id() );
    }
}

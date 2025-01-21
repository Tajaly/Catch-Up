package com.application.hangouts.persistence;

import com.application.hangouts.persistence.dto.PersonDto;
import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.persistence.spring.data.SpringDataPersonRepository;
import com.application.hangouts.logic.domain.services.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final SpringDataPersonRepository springDataPersonRepository;


    //Constructor injection

    public PersonRepositoryImpl(SpringDataPersonRepository springDataPersonRepository) {
        this.springDataPersonRepository = springDataPersonRepository;
    }

    public List<Person> findAll(){
        return springDataPersonRepository.findAll().stream().map(this::toPerson).collect(Collectors.toList());
    }

    public Optional<Person> findPersonByEmail(String email) {
        return springDataPersonRepository.findPersonByEmail(email).map(this::toPerson);
    }

    @Override
    public Integer saveNewPerson(Person person) {
        PersonDto personDto = toPersonDto(person);
        springDataPersonRepository.saveNewPerson(personDto.email(), personDto.name(), personDto.bio());
        return 1;
    }

    @Override
    public void deleteByEmail(String email) {
        springDataPersonRepository.deleteByEmail(email);
    }


    // Dto to domain
    private PersonDto toPersonDto(Person person) {
        return new PersonDto(person.getEmail(), person.getName(), person.getBio());
    }

    private Person toPerson (PersonDto personDto) {
        return new Person(personDto.email(), personDto.name(), personDto.bio());
    }
}

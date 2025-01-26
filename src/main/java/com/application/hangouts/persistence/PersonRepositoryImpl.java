package com.application.hangouts.persistence;

import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.persistence.dto.PersonDto;
import com.application.hangouts.logic.domain.model.Person;
import com.application.hangouts.persistence.spring.data.SpringDataPersonRepository;
import com.application.hangouts.logic.domain.services.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final SpringDataPersonRepository springDataPersonRepository;

    public PersonRepositoryImpl(SpringDataPersonRepository springDataPersonRepository) {
        this.springDataPersonRepository = springDataPersonRepository;
    }

    public List<Person> findAll(){
        return springDataPersonRepository.findAll().stream().map(this::toPerson).collect(Collectors.toList());
    }

    public Optional<Person> findPersonByUsername(String username) {
        return springDataPersonRepository.findPersonByUsername(username).map(this::toPerson);
    }

    @Override
    public Integer saveNewPerson(Person person) {
        PersonDto personDto = toPersonDto(person);
        springDataPersonRepository.saveNewPerson(personDto.username(), personDto.name(), personDto.bio());
        return 1;
    }

    @Override
    public void deleteByUsername(String username) {
        springDataPersonRepository.deleteByUsername(username);
    }

    public Set<Integer> findCirclesByPerson(String username) {
        return springDataPersonRepository.findCirclesByPerson(username).stream().collect(Collectors.toSet());
    }

    public void addMemberToCircle(Integer id, String username){
        springDataPersonRepository.addMemberToCircle(username, id);
    }


    // Dto to domain
    private PersonDto toPersonDto(Person person) {
        return new PersonDto(person.getUsername(), person.getName(), person.getBio());
    }

    private Person toPerson (PersonDto personDto) {
        return new Person(personDto.username(), personDto.name(), personDto.bio());
    }
}

package com.application.catchup.persistence;

import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.persistence.dto.PersonDto;
import com.application.catchup.logic.domain.model.Person;
import com.application.catchup.persistence.spring.data.SpringDataPersonRepository;
import com.application.catchup.logic.domain.services.PersonRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Repository;

import java.util.*;
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


    public void addMemberToCircle(Integer id, String username){
        springDataPersonRepository.addMemberToCircle(username, id);
    }

    public Set<Integer> findCircleIdsByPerson(String username) {
        Set<Integer> set = new HashSet<>();
        set.addAll(springDataPersonRepository.findCirclesByPerson(username));
       return set;
    }




    // Dto to domain
    private PersonDto toPersonDto(Person person) {
        return new PersonDto(person.getUsername(), person.getName(), person.getBio());
    }

    private Person toPerson (PersonDto personDto) {
        return new Person(personDto.username(), personDto.name(), personDto.bio());
    }


}

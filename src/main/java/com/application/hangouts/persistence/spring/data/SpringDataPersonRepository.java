package com.application.hangouts.persistence.spring.data;

import com.application.hangouts.persistence.dto.PersonDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface SpringDataPersonRepository extends CrudRepository<PersonDto, String> {
    Collection<PersonDto> findAll();

    Optional<PersonDto> findPersonByName(String name);

    @Override
    PersonDto save(PersonDto person);



    void deletePersonByName(String name);

}

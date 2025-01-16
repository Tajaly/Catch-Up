package com.application.hangouts.domain.persistence.spring.data;

import com.application.hangouts.domain.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

//TODO schauen ob es funktioniert mit String als Primary key
public interface SpringDataPersonRepository extends CrudRepository<Person, String> {
    Collection<Person> findAll();

    Optional<Person> findPersonByName(String name);

    @Override
    Person save(Person person);



    void deletePersonByName(String name);

}

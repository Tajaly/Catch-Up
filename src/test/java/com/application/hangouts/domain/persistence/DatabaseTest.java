package com.application.hangouts.domain.persistence;

import com.application.hangouts.domain.model.Person;
import com.application.hangouts.domain.persistence.spring.data.CircleRepository;
import com.application.hangouts.domain.persistence.spring.data.SpringDataPersonRepository;
import com.application.hangouts.web.ContainerConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Import(ContainerConfig.class)
public class DatabaseTest {

    @Autowired
    CircleRepository circleRepository;

    @Autowired
    SpringDataPersonRepository personRepository;
    /*
    @Test
    @DisplayName("Circle kann gespeichert und geladen werden")
    void test1() throws Exception {
        Circle c = new Circle( List.of(new User("hallo")));
        Circle saved = circleRepository.save(c);
        Circle newCircle = circleRepository.findById(saved.getId()).orElseThrow();
        assertThat(newCircle.getId()).isEqualTo(saved.getId());

    }

     */


//Wenn
    @Test
    @DisplayName("Person kann gespeichert und geladen werden")
    void test1() throws Exception {
        Person person = new Person("taja");
        Person savedUser = personRepository.save(person);
        Person dbPerson = personRepository.findPersonByName(person.getName()).orElseThrow();
       // System.out.println("\n \n \n \n" + dbPerson + "\n\n\n\n");
        assertThat(dbPerson).isNotNull();
        assertThat(dbPerson.getName()).isEqualTo(person.getName());

    }
}

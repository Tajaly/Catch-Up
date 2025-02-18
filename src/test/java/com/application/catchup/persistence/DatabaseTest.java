package com.application.catchup.persistence;

import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.logic.domain.model.Person;
import com.application.catchup.logic.domain.services.CircleRepository;
import com.application.catchup.logic.domain.services.PersonRepository;
import com.application.catchup.ContainerConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Import(ContainerConfig.class)
public class DatabaseTest {

    //weil wir im Service das PersonRepository nutzen:
    @Autowired
    SpringDataPersonRepository springPersonRepository;

    @Autowired
    SpringDataCircleRepository springDataCircleRepository;



    PersonRepository personRepository;

    CircleRepository circleRepository;



    @BeforeEach
    void setUp() {
        personRepository = new PersonRepositoryImpl(springPersonRepository);
        circleRepository = new CircleRepositoryImpl(springDataCircleRepository);
    }

    @Test
    @DisplayName("Person kann gespeichert und geladen werden")
    void test1() throws Exception {
        Person person = new Person("taja@hotmail.de", "taja", "hallo");
        Integer n = personRepository.saveNewPerson(person);

        Person dbPerson = personRepository.findPersonByUsername(person.getUsername()).orElseThrow();
       // System.out.println("\n \n \n \n" + dbPerson + "\n\n\n\n");
        assertThat(dbPerson).isNotNull();
        assertThat(dbPerson.getUsername()).isEqualTo(person.getUsername());



    }

    //saveAll implementieren?
    @Test
    @DisplayName("mehrere Personen können gespeichert und geladen werden")
    void test2() throws Exception {
        Person person = new Person("taja@hotmail.de", "taja", "hallo");
        Person person2 = new Person("schieno@yahoo.de", "schieno", "ich bins");
        Person person3 = new Person("timmy@timmy.com", "timmy", "wau wau");
        personRepository.saveNewPerson(person);
        personRepository.saveNewPerson(person2);
        personRepository.saveNewPerson(person3);
        List<Person> list = personRepository.findAll();
         //System.out.println("\n \n \n \n" + list + "\n\n\n\n");
        assertThat(list).hasSize(3);
    }



    @Test
    @DisplayName("Person kann gespeichert und gelöscht werden")
    void test3() throws Exception {
        Person person = new Person("taja@hotmail.de", "taja", "hallo");
        Integer n = personRepository.saveNewPerson(person);
        Person dbPerson = personRepository.findPersonByUsername(person.getUsername()).orElseThrow();


        personRepository.deleteByUsername("taja@hotmail.de");
        assertThat(personRepository.findAll()).isEmpty();
      //  System.out.println("\n \n \n \n" + personRepository.findAll() + "\n\n\n\n");

    }


    @Test
    @DisplayName("Circle können gespeichert und geladen werden")
    void test4() throws Exception {
        Person person = new Person("abc@abc.abc", "taja", "hallo");
        Integer n = personRepository.saveNewPerson(person);
        Circle circle = new Circle("Handball", "abc@abc.abc" );
        Circle saved = circleRepository.save(circle);
        assertThat(saved).isNotNull();
        System.out.println("\n \n \n \n" + saved + "\n\n\n\n");

        Circle dbCircle = circleRepository.findById(saved.getId());
        assertThat(dbCircle).isNotNull();
    }




}

package com.application.catchup.logic.domain.services.old;

import com.application.catchup.logic.domain.model.Person;
import com.application.catchup.logic.domain.services.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepository personRepository;




    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addMemberToCircle(Integer id, String username){
        personRepository.addMemberToCircle(id, username);
    }

    public void saveNewPerson(Person person) {
        personRepository.saveNewPerson(person);
    }

    /*
    public Optional<Person> findPersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    };

     */
}

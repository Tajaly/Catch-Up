package com.application.hangouts.persistence.spring.data;

import com.application.hangouts.persistence.dto.PersonDto;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SpringDataPersonRepository extends CrudRepository<PersonDto, String> {

    //derived queries from Spring Data

    //TODO retruned doch ein set?
    @Override
    Collection<PersonDto> findAll();




    //custom derived queries
    Optional<PersonDto> findPersonByEmail(String email);

   // List<PersonDto> deleteByName(String name);


    //custom queries
    @Modifying
    @Query("delete from person where person.email = :email")
    void deleteByEmail(@Param("email") String email);

    @Modifying
    @Query("insert into Person (email, name, bio) values (:email, :name, :bio)")
    Integer saveNewPerson(@Param("email") String email, @Param("name") String name, @Param("bio") String bio);


}

package com.application.catchup.persistence;

import com.application.catchup.persistence.dto.PersonDto;
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
    Optional<PersonDto> findPersonByUsername(String username);

   // List<PersonDto> deleteByName(String name);


    //custom queries
    @Modifying
    @Query("delete from person where person.username = :username")
    void deleteByUsername(@Param("username") String username);

    @Modifying
    @Query("insert into person (username, name, bio) values (:username, :name, :bio)")
    Integer saveNewPerson(@Param("username") String username, @Param("name") String name, @Param("bio") String bio);



    //Circle related quieries:

    //add Person to circle
    @Modifying
    @Query("insert into circle_member (person, circle) values (:username, :id)")
    Integer addMemberToCircle(@Param("username") String username, @Param("id") Integer id);

    //find all Circles from a Person
    @Query("select circle from circle_member where person = :username")
    Collection<Integer> findCirclesByPerson(@Param("username") String username);



}

package com.application.catchup.persistence;

import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.logic.domain.model.Person;
import com.application.catchup.persistence.dto.CircleDto;
import com.application.catchup.persistence.dto.HangoutDto;
import com.application.catchup.persistence.dto.PersonDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SpringDataCircleRepository extends CrudRepository<CircleDto, Integer> {
    @Override
    Collection<CircleDto> findAll();

    Collection<CircleDto> findByOrganizer(String organizer);

    @Override
    CircleDto save(CircleDto circle);


    Optional<CircleDto> findById(Integer id);

    //returns usernames
    @Query("select person from circle_member where circle = :circleid")
    Collection<String> getMemberByCircleId(@Param("circleid") Integer circleid);
    /*

    @Id
    @Column("hangout_id") Integer id, String name, String description,
    String organizer, Integer circle, java.time.LocalDateTime startTime, LocalDateTime endTime

    hangout_id integer unique,
    name varchar(50),
    description varchar(300),
    organizer varchar(70) references person (username),
    start_time TIMESTAMP WITHOUT TIME ZONE,
    end_time TIMESTAMP WITHOUT TIME ZONE,
    circle integer,
    circle_key integer,

    SELECT * FROM Lehrer
WHERE Gehalt = (
    SELECT MAX(Gehalt) FROM Lehrer
);

     */

    @Query("select hangout_id as id ,name ,description ,organizer ,start_time as startTime ,end_time as endTime" +
        " from hangout where circle = :circleid and circle_key = (Select max(circle_key) from hangout where circle = :circleid)")
    Optional<HangoutDto> getLastAddedHangout(@Param("circleid") Integer circleid);


    //List<CircleDto> findByName(String name);




}

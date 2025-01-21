package com.application.hangouts.logic.domain.services;

import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.persistence.dto.CircleDto;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircleRepository {
    Circle save(Circle circle);




    void deleteCircle(Circle circle);

    Circle findById(Integer id);

    //List<Circle> getAllCirclesFromPerson(Integer personId);

    /*
    Circle findCircleByEmail(String email);

     */




}

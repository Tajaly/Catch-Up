package com.application.catchup.logic.domain.services;

import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.persistence.dto.CircleDto;
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
    Circle findCircleByUsername(String username);

     */




}

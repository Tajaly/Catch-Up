package com.application.hangouts.persistence.spring.data;

import com.application.hangouts.logic.domain.model.Circle;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface CircleRepository extends CrudRepository<Circle, Integer> {
    Collection<Circle> findAll();

    Optional<Circle> findById(Integer id);

    Circle save(Circle circle);
}

package com.application.hangouts.domain.persistence;

import com.application.hangouts.domain.model.Circle;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface CircleRepository extends CrudRepository<Circle, Integer> {
    Collection<Circle> findAll();

    Optional<Circle> findById(Integer id);

    Circle save(Circle circle);
}

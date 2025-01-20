package com.application.hangouts.persistence;

import com.application.hangouts.logic.domain.model.Circle;

import java.util.HashSet;
import java.util.Set;

//Klasse überflüssig
public class CircleRepositoryImpl {

    Set<Circle> circle = new HashSet<>();
    /*

    @Override
    public Collection<Circle> findAll() { return circle; }

    @Override
    public Optional<Circle> findById(Integer id) {
        return circle.stream().filter(c -> c.getId() == id).findFirst();
    }

    @Override
    public synchronized Circle save(Circle circle) {
        return circle;
    }

     */
}

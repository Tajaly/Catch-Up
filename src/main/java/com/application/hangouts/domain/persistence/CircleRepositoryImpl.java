package com.application.hangouts.domain.persistence;

import com.application.hangouts.domain.model.Circle;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CircleRepositoryImpl implements CircleRepository{

    Set<Circle> circle = new HashSet<>();

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
}

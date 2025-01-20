package com.application.hangouts.persistence;

import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.logic.domain.services.CircleRepository;
import com.application.hangouts.persistence.dto.CircleDto;
import com.application.hangouts.persistence.spring.data.SpringDataCircleRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Repository
public class CircleRepositoryImpl  implements CircleRepository {

    private final SpringDataCircleRepository springDataCircleRepository;

    public CircleRepositoryImpl(SpringDataCircleRepository springDataCircleRepository) {
        this.springDataCircleRepository = springDataCircleRepository;
    }

    //@Override
    public CircleDto save(CircleDto circle) {
        return springDataCircleRepository.save(circle);
    }

   // Set<Circle> circle = new HashSet<>();
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

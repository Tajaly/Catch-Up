package com.application.catchup.persistence;

import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.logic.domain.model.Person;
import com.application.catchup.logic.domain.services.CircleRepository;
import com.application.catchup.persistence.dto.CircleDto;
import com.application.catchup.persistence.spring.data.SpringDataCircleRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;


@Repository
public class CircleRepositoryImpl  implements CircleRepository {

    private final SpringDataCircleRepository springDataCircleRepository;

    public CircleRepositoryImpl(SpringDataCircleRepository springDataCircleRepository) {
        this.springDataCircleRepository = springDataCircleRepository;
    }

    @Override
    public Circle save(Circle circle) {
        return toCircle(springDataCircleRepository.save(toCircleDto(circle)));
    }

    @Override
    public void deleteCircle(Circle circle){
        springDataCircleRepository.deleteById(circle.getId());
    }



    Set<Circle> findByOrganizer(String organizer) {
        return springDataCircleRepository.findByOrganizer(organizer).stream().map(this::toCircle).collect(Collectors.toSet());
    }

    private CircleDto toCircleDto(Circle circle) {
        return new CircleDto(null, circle.getName(), circle.getOrganizer());
    }

    private Circle toCircle(CircleDto circleDto) {
        return new Circle(circleDto.id(), circleDto.name(), circleDto.organizer());
    }

    public Circle findById(Integer id) {
        return toCircle(springDataCircleRepository.findById(id).orElseThrow());
    }



   // Set<Circle> circle = new HashSet<>();
    /*

    @Override
    public Collection<Circle> findAll() { return circle; }

    @Override
    public Optional<Circle> findById(Integer id) {
        return circle.stream().filter(c -> c.getId() == id).findFirst();
    }



     */
}

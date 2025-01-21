package com.application.hangouts.logic.domain.services;

import com.application.hangouts.logic.domain.model.Circle;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CircleService {

    CircleRepository circleRepository;

    public CircleService(CircleRepository circleRepository) {
        this.circleRepository = circleRepository;
    }

    public Integer createCircle(String name, String email) {
        Circle circle = new Circle(name, email);
        return circleRepository.save(circle).getId();
    }



}

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

    public Circle createCircle(String name, String username) {
        Circle circle = new Circle(name, username);
        return circleRepository.save(circle);
    }



}

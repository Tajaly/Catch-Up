package com.application.catchup.logic.domain.services.old;

import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.logic.domain.services.CircleRepository;
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

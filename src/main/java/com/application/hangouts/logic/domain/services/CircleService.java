package com.application.hangouts.logic.domain.services;

import org.springframework.stereotype.Service;

@Service
public class CircleService {

    CircleRepository circleRepository;

    public CircleService(CircleRepository circleRepository) {
        this.circleRepository = circleRepository;
    }



}

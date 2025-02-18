package com.application.hangouts.logic.domain.services;

import com.application.hangouts.logic.domain.model.Hangout;
import com.application.hangouts.persistence.dto.HangoutDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


public interface HangoutRepository {

    Collection<Hangout> findAll();

    Collection<Hangout> findByOrganizer(String organizer);

    Collection<Hangout> findByCircle(Integer id);


    Hangout save(Hangout hangout);


    Hangout findById(Integer id);
}

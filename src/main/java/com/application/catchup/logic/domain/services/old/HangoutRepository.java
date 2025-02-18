package com.application.catchup.logic.domain.services.old;

import com.application.catchup.logic.domain.model.Hangout;
import com.application.catchup.persistence.dto.HangoutDto;
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

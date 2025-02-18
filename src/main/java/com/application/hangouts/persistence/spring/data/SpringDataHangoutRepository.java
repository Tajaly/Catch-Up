package com.application.hangouts.persistence.spring.data;

import com.application.hangouts.logic.domain.model.Hangout;
import com.application.hangouts.persistence.dto.CircleDto;
import com.application.hangouts.persistence.dto.HangoutDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface SpringDataHangoutRepository extends CrudRepository<HangoutDto, Integer> {
    @Override
    Collection<HangoutDto> findAll();

    Collection<HangoutDto> findByOrganizer(String organizer);

    Collection<HangoutDto> findByCircle(Integer id);

    @Override
    HangoutDto save(HangoutDto hangout);


    Optional<HangoutDto> findById(Integer id);
}

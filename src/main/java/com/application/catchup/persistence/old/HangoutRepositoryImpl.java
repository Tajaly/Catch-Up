package com.application.catchup.persistence.old;

import com.application.catchup.logic.domain.model.Hangout;
import com.application.catchup.logic.domain.services.old.HangoutRepository;
import com.application.catchup.persistence.dto.HangoutDto;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class HangoutRepositoryImpl implements HangoutRepository {

    SpringDataHangoutRepository springDataHangoutRepository;

    public HangoutRepositoryImpl(SpringDataHangoutRepository springDataHangoutRepository) {
        this.springDataHangoutRepository = springDataHangoutRepository;
    }

    @Override
    public Set<Hangout> findAll(){
        return springDataHangoutRepository.findAll().stream().map(this::DtoToHangout).collect(Collectors.toSet());
    }

    public Set<Hangout> findByOrganizer(String organizer){
        return springDataHangoutRepository.findByOrganizer(organizer).stream().map(this::DtoToHangout).collect(Collectors.toSet());
    }

    public Set<Hangout> findByCircle(Integer id){
        return springDataHangoutRepository.findByCircle(id).stream().map(this::DtoToHangout).collect(Collectors.toSet());
    }

    @Override
    public Hangout save(Hangout hangout){
        return DtoToHangout(springDataHangoutRepository.save(HangoutToDto(hangout)));
    }


    public Hangout findById(Integer id){
            return DtoToHangout(springDataHangoutRepository.findById(id).orElseThrow());
    }

    private Hangout DtoToHangout(HangoutDto hangoutDto) {
        return new Hangout(hangoutDto.id(), hangoutDto.name(), hangoutDto.description(), hangoutDto.organizer(), hangoutDto.circle(),
            hangoutDto.startTime(), hangoutDto.endTime());
    }

    private HangoutDto HangoutToDto(Hangout hangout) {
        return new HangoutDto(hangout.getId(), hangout.getName(), hangout.getDescription(), hangout.getOrganizer(), hangout.getCircle(),
            hangout.getStart(), hangout.getEnd());
    }
}

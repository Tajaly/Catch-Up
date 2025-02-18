package com.application.catchup.persistence;

import com.application.catchup.logic.domain.model.Circle;
import com.application.catchup.logic.domain.model.Hangout;
import com.application.catchup.logic.domain.model.Person;
import com.application.catchup.logic.domain.services.CircleRepository;
import com.application.catchup.persistence.dto.CircleDto;
import com.application.catchup.persistence.dto.HangoutDto;
import com.application.catchup.persistence.dto.PersonDto;
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
    public Hangout getLastAddedHangout(Integer circle){
        return toHangout(springDataCircleRepository.getLastAddedHangout(circle).orElseThrow());
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
        if (circle.getId()==null){
            return new CircleDto(null, circle.getName(), circle.getOrganizer(), new ArrayList<HangoutDto>());
        }
        return new CircleDto(circle.getId(), circle.getName(), circle.getOrganizer(), toHangoutsDtos(circle.getHangouts()));
    }
    private List<PersonDto> toMemberDtos(List<Person> persons) {
        return persons.stream().map(this::toPersonDto).collect(Collectors.toList());
    }

    private PersonDto toPersonDto(Person person) {
        return new PersonDto(person.getUsername(), person.getName(), person.getBio());
    }

    private Person toPerson (PersonDto personDto) {
        return new Person(personDto.username(), personDto.name(), personDto.bio());
    }

    private List<HangoutDto> toHangoutsDtos (List<Hangout> hangouts) {
        return hangouts.stream().map(this::toHangoutsDto).toList();
    }
    private Hangout toHangout(HangoutDto hangoutDto) {
        return new Hangout(hangoutDto.id(), hangoutDto.name(), hangoutDto.description(), hangoutDto.organizer(), hangoutDto.circle(),
            hangoutDto.startTime(), hangoutDto.endTime());
    }
    private List<Hangout> toHangouts(List<HangoutDto> hangoutDtos) {
        return hangoutDtos.stream().map(this::toHangout).collect(Collectors.toList());
    }

    private HangoutDto toHangoutsDto(Hangout hangout) {
        return new HangoutDto(hangout.getId(), hangout.getName(), hangout.getDescription(), hangout.getOrganizer(), hangout.getCircle(),
            hangout.getStart(), hangout.getEnd());
    }

    private Circle toCircle(CircleDto circleDto) {
        Set<String> usernames = new HashSet<>(springDataCircleRepository.getMemberByCircleId(circleDto.id()));
        return new Circle(circleDto.id(), circleDto.name(), circleDto.organizer(), usernames, toHangouts(circleDto.hangouts()));
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

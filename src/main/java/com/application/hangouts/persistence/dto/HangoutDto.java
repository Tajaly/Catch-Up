package com.application.hangouts.persistence.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table("hangout")
public record HangoutDto(@Id Integer id, String name,String description,
                         String organizer,Integer circle, LocalDateTime startTime, LocalDateTime endTime) {
}

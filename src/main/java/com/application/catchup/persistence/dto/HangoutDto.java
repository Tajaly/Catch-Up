package com.application.catchup.persistence.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table("hangout")
public record HangoutDto(@Id @Column("hangout_id") Integer id, String name, String description,
                         String organizer, Integer circle, LocalDateTime startTime, LocalDateTime endTime) {
}

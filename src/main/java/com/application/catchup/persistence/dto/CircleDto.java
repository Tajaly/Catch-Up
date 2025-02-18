package com.application.catchup.persistence.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;


@Table("circle")
public record CircleDto(@Id @Column("circle_id") Integer id, String name, String organizer, List<HangoutDto> hangouts) {
}

package com.application.catchup.persistence.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("circle")
public record CircleDto(@Id Integer id, String name, String organizer) {
}

package com.application.hangouts.persistence.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("person")
public record PersonDto (@Id Integer id, String name) {}

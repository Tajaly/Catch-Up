package com.application.catchup.persistence.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("person")
public record PersonDto (@Id String username, String name, String bio) {}
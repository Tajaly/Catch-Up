package com.application.hangouts;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration
public class ContainerConfig {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> createTestContainer() {
        return new PostgreSQLContainer<>("postgres:15-alpine");
    }
}

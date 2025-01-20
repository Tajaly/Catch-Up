package com.application.hangouts.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

//Tests nutzen einen TestContainer der in ConfigClass konfigueriert wird
@SpringBootTest
@Import(ContainerConfig.class)
class HangoutsApplicationTests {

    @Test
    void contextLoads() {
    }

}

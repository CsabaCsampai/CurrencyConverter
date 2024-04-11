package com.example.CurrencyConverter;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CurrencyConverterApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        // Test ci sa Spring Boot kontext aplikacie sa uspesne nacita
        assertThat(context).isNotNull();
    }

}

package com.springboot_githubactions.springboot_githubactions.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//https://blog.devgenius.io/brushing-up-on-junit-5-and-mockito-testing-a-spring-boot-task-manager-1c824fb17fec
@SpringBootTest
public class CalculatorServiceTest {
    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testSuma() {
        assertEquals(calculatorService.suma(2,3), 4);
    }
}
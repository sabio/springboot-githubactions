package com.springboot_githubactions.springboot_githubactions.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int suma(int a, int b) {
        return a + b;
    }
}

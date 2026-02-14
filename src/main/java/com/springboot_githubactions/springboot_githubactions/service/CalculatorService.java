package com.springboot_githubactions.springboot_githubactions.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int suma(int a, int b) {
        return a + b;
    }

    public double suma(double a, double b) {
        return a + b;
    }
}

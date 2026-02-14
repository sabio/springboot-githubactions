package com.springboot_githubactions.springboot_githubactions.controller;

import com.springboot_githubactions.springboot_githubactions.dto.Person;
import com.springboot_githubactions.springboot_githubactions.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class HelloController {
    CalculatorService calculatorService;

    @GetMapping
    @RequestMapping("/hello")
    public String hello() {
        return "hello world. Now = "+ OffsetDateTime.now();
    }

    @GetMapping
    @RequestMapping("/suma")
    public int suma(@RequestParam(name = "op1") int a, @RequestParam(name = "op2") int b) {
        return calculatorService.suma(a,b);
    }

    @GetMapping("/person")
    public Person person() {
        return new Person(1, "Armando");
    }

    @ExceptionHandler({Exception.class})
    public String databaseError(Exception ex) {
        return "error";
    }

}

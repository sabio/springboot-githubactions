package com.springboot_githubactions.springboot_githubactions.controller;

import com.springboot_githubactions.springboot_githubactions.dto.Person;
import com.springboot_githubactions.springboot_githubactions.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @RequestMapping(path = "/resta/{op1}/{op2}", method = RequestMethod.GET)
    public int resta(@PathVariable("op1") int a, @PathVariable("op2") int b) {
        return calculatorService.resta(a,b);
    }

    @RequestMapping("/person")
    public Person person() {
        return new Person(1, "Armando");
    }

    @GetMapping("/people")
    public List<Person> persons() throws IOException {
        ClassPathResource resource = new ClassPathResource("/jsons/people.json");
        String str = Files.readString(resource.getFile().toPath());

        JSONArray jsonArray = new JSONArray(str);

        List<Person> result = IntStream.range(0, jsonArray.length())
                .mapToObj(i -> jsonArray.getJSONObject(i))
                .map(jsonObject -> new Person(jsonObject.getInt("id"), jsonObject.getString("name")))
                .collect(Collectors.toList());


        return result;

    }

    @ExceptionHandler({Exception.class})
    public String databaseError(Exception ex) {
        ex.printStackTrace();
        return "error";
    }

}

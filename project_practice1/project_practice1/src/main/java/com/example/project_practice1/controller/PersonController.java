package com.example.project_practice1.controller;

import com.example.project_practice1.prac.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {
    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setName("lee");
        person.setAddress("korea");
        person.setAge(20);
        person.setJob("student");
        return person;
    }
}
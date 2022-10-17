package com.example.spring_sec_app.controllers;

import com.example.spring_sec_app.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    @GetMapping("/hello")
    public String hello(){
        return "hello.html";
    }

    @GetMapping("/showInfo")
    public String showInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello.html";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}

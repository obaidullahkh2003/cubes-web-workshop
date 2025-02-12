package io.spring.start.controllers;

import io.spring.start.models.User;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {
    @GetMapping("/welcome")
    public String welcome() {
        System.out.println("Welcome to Spring Boot in consol");
        return "Welcome to Spring Boot!";

    }
}

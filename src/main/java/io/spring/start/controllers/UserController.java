package io.spring.start.controllers;

import io.spring.start.models.User;
import io.spring.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/create")
    public String saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

}

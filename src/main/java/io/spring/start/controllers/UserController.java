package io.spring.start.controllers;

import io.spring.start.models.User;
import io.spring.start.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
//    @Autowired

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public String saveUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }




    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable int id,@Valid @RequestBody User user) {
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}

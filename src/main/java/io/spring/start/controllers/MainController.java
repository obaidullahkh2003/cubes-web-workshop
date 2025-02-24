package io.spring.start.controllers;

import io.spring.start.models.User;
import io.spring.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
    @Autowired
    UserService userService ;

    @GetMapping("/user/{name}")
    public String getUser(@PathVariable String name, Model model) {
        User user=userService.getUserByName(name);
        model.addAttribute("user",user);
        return "profile";
    }
}

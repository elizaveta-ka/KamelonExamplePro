package com.example.kamelonexamplepro.controller;

import com.example.kamelonexamplepro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.kamelonexamplepro.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user", produces = "application/json")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    private User getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    //create new User
    @PostMapping(value = "/user")
    private int saveUser(@RequestBody User user)
    {
        userService.saveOrUpdateUser(user);
        return user.getId();
    }
}

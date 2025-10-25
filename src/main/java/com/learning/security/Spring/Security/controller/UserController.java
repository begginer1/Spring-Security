package com.learning.security.Spring.Security.controller;

import com.learning.security.Spring.Security.model.Users;

import com.learning.security.Spring.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @Autowired
    private UserService userService;



    @PostMapping("/register")
    Users RegisterUser(@RequestBody Users user)
    {
        return userService.Register(user);

    }
    @PostMapping("/login")
    String Login(@RequestBody Users user)
    {
        return userService.verify(user);
    }
}

package com.example.RegisterLogin.controller;

import com.example.RegisterLogin.Service.UserService;
import com.example.RegisterLogin.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("register")
public class RegisterController {

    private final UserService<User> userService;

    public RegisterController(UserService<User> userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/save")
    public boolean saveUser(@RequestBody User user){
        userService.save(user);

        return true;
    }
}

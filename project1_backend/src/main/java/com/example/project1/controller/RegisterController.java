package com.example.project1.controller;

import com.example.project1.model.User;
import com.example.project1.service.RegisterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @PostMapping
    public Boolean Register(@RequestBody User user) {
        return RegisterService.Register(user);
    }
}

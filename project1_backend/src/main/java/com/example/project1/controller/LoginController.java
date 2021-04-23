package com.example.project1.controller;

import com.example.project1.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @PostMapping
    public String Login(@RequestBody String data) {
        return LoginService.Login(data);
    }
}

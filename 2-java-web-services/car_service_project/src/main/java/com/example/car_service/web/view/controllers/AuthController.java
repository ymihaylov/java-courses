package com.example.car_service.web.view.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class AuthController {
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        final String welcomeMessage = "Welcome to the Car Service System!";
        model.addAttribute("welcome", welcomeMessage);
        return "unauthorized";
    }
}

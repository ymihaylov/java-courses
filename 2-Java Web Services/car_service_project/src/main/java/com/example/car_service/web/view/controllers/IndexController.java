package com.example.car_service.web.view.controllers;

import com.example.car_service.data.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(Model model, Authentication authentication) {
//        if (authentication == null) {
//            return "redirect:/login";
//        }

//        User principal = (User) authentication.getPrincipal();

        return "/hello-secured";
    }

    @GetMapping("/secured")
    public String indexSecured() {
        return "/hello-secured";
    }
}

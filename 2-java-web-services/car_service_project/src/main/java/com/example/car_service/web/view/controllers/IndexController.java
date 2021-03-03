package com.example.car_service.web.view.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

        // @TODO REFACTOR THIS AND ADD MORE AUTHORITIES
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CLIENT"))) {
            return "redirect:/my-cars";
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CAR_SHOP_EMPLOYEE"))) {
            return "redirect:/repair-shop/pending-appointments";
        }

        return "/hello-secured";
    }
}

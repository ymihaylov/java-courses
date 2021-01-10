package com.example.car_service.web.view.controllers.client;

import com.example.car_service.data.entity.User;
import com.example.car_service.services.CarService;
import com.example.car_service.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    private final UserService userService;

    @GetMapping("/my-cars")
    public String getClientCars(Model model) {
        User user = userService.getCurrentLoggedUser();
        model.addAttribute("cars", carService.getCarsByUser(user));

        return "/cars/list";
    }
}

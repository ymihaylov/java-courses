package com.example.car_service.web.view.controllers;

import com.example.car_service.data.entity.Appointment;
import com.example.car_service.data.entity.Car;

import com.example.car_service.services.CarManufacturerService;
import com.example.car_service.services.CarService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarsController {
    private final CarService carService;
    private final CarManufacturerService carManufacturerService;

    @GetMapping()
    public String getClientCars(Model model) {
        model.addAttribute("cars", carService.getCars());

        return "/cars/list";
    }

    @GetMapping("/create")
    public String showCreateCarForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("carManufacturers", this.carManufacturerService.getCarManufactures());

        return "/cars/create";
    }

    @PostMapping("/create")
    public String createCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars/create";
        }

        carService.create(car);

        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String showEditCarForm(Model model, @PathVariable Long id) {
        model.addAttribute("car", carService.getCar(id));
        model.addAttribute("carManufacturers", this.carManufacturerService.getCarManufactures());

        return "/cars/edit";
    }

    @PostMapping("/update/{id}")
    public String updateSchool(@PathVariable long id, @Valid @ModelAttribute("school") Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/cars/edit";
        }

        carService.updateCar(id, car);

        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carService.deleteSchool(id);
        return "redirect:/cars";
    }
}

package com.example.car_service.web.view.controllers;

import com.example.car_service.data.entity.Appointment;
import com.example.car_service.services.CarService;
import com.example.car_service.services.CarServiceService;
import com.example.car_service.services.RepairShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {
    private final CarService carService;

    private final RepairShopService repairShopService;

    private final CarServiceService carServiceService;

    @GetMapping("/create")
    public String showCreateAppointmentForm(Model model) {
        model.addAttribute("cars", carService.getCars());
        model.addAttribute("repairShops", repairShopService.getRepairShops());
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("carServices", carServiceService.getServices());

        return "/appointments/create";
    }

    @PostMapping("/create")
    public String scheduleAppointment(@Valid @ModelAttribute("appointment") Appointment appointment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            return "/cars/schedule-appointment";
        }

//        return "redirect:/cars";
    }
}

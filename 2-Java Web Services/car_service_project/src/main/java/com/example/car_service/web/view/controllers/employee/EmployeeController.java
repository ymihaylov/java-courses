package com.example.car_service.web.view.controllers.employee;

import com.example.car_service.data.entity.Appointment;
import com.example.car_service.data.entity.RepairShop;
import com.example.car_service.data.entity.User;
import com.example.car_service.services.*;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@PreAuthorize("hasAuthority('CAR_SHOP_EMPLOYEE')")
@RequestMapping("/repair-shop")
public class EmployeeController {
    private final CarService carService;
    private final UserService userService;
    private final CarManufacturerService carManufacturerService;
    private final AppointmentsService appointmentsService;
    private final RepairShopService repairShopService;
    private final CarServiceService carServiceService;

    @GetMapping("/pending-appointments")
    public String getClientCars(Model model) {
        RepairShop currentRepairShop = repairShopService.getCurrentRepairShopByLoggedUser();

        model.addAttribute("appointments", appointmentsService.getPendingAppointmentsByRepairShop(currentRepairShop));
        model.addAttribute("repairShop", currentRepairShop);

        return "/appointments/list-service-pending";
    }

    @GetMapping("/appointments/{appointmentId}/edit")
    public String showEditAppointmentForm(Model model, @PathVariable int appointmentId, HttpServletRequest request) {
        model.addAttribute("appointment", appointmentsService.getAppointment(appointmentId));
        model.addAttribute("carServices", carServiceService.getServices());
        model.addAttribute("repairShop", repairShopService.getCurrentRepairShopByLoggedUser());

        return "/appointments/edit-service";
    }

    @PostMapping("/appointments/{appointmentId}/edit")
    public String updateAppointment(
        Model model,
        @PathVariable long appointmentId,
        @Valid @ModelAttribute("appointment") Appointment appointmentViewModel,
        BindingResult bindingResult
    ) {
        Appointment appointment = appointmentsService.getAppointment(appointmentId);

        appointment.setDate(appointmentViewModel.getDate());
        appointment.setTime(appointmentViewModel.getTime());
        appointment.setStatus(appointmentViewModel.getStatus());
        appointment.setPrice(appointmentViewModel.getPrice());
        appointment.setServices(appointmentViewModel.getServices());

        if (bindingResult.hasErrors()) {
            model.addAttribute("appointment", appointment);
            return "/appointments/edit-service";
        }

        appointmentsService.updateAppointment(appointmentId, appointment);

        return "redirect:/repair-shop/pending-appointments";
    }
}

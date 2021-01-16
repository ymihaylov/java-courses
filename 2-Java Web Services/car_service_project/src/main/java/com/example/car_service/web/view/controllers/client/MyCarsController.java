package com.example.car_service.web.view.controllers.client;

import com.example.car_service.data.entity.Appointment;
import com.example.car_service.data.entity.AppointmentStatus;
import com.example.car_service.data.entity.Car;
import com.example.car_service.data.entity.User;
import com.example.car_service.services.*;
import com.example.car_service.web.view.model.UpdateAppointmentViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/my-cars")
//@PreAuthorize("hasAuthority('CLIENT')")
public class MyCarsController {
    private final CarService carService;
    private final UserService userService;
    private final CarManufacturerService carManufacturerService;
    private final AppointmentsService appointmentsService;
    private final RepairShopService repairShopService;
    private final CarServiceService carServiceService;
    private final ModelMapper modelMapper;

    @GetMapping()
    public String getClientCars(Model model) {
        User user = userService.getCurrentLoggedUser();
        model.addAttribute("cars", carService.getCarsByUser(user));

        return "/cars/list";
    }

    @GetMapping("/add-car")
    public String showCreateCarForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("carManufacturers", this.carManufacturerService.getCarManufactures());

        return "/cars/create";
    }

    @PostMapping("/create")
    public String createCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }

        car.setUser(userService.getCurrentLoggedUser());
        carService.create(car);

        return "redirect:/my-cars";
    }

    @GetMapping("/edit/{id}")
    public String showEditCarForm(Model model, @PathVariable Long id) {
        model.addAttribute("car", carService.getCar(id));
        model.addAttribute("carManufacturers", this.carManufacturerService.getCarManufactures());

        return "/cars/edit";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable long id, @Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/cars/edit";
        }

        car.setUser(userService.getCurrentLoggedUser());
        carService.updateCar(id, car);

        return "redirect:/my-cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return "redirect:/my-cars";
    }

    @GetMapping("/{id}/history")
    public String getCarHistory(Model model, @PathVariable int id) {
        Car car = carService.getCar(id);

        model.addAttribute("car", car);
        model.addAttribute("appointments", appointmentsService.getAppointmentsByCar(car));

        return "/appointments/list";
    }

    @GetMapping("/{id}/schedule-appointment")
    public String showScheduleAppointmentForm(Model model, @PathVariable int id) {
        model.addAttribute("car", carService.getCar(id));
        model.addAttribute("repairShops", repairShopService.getRepairShops());
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("carServices", carServiceService.getServices());

        return "/appointments/create";
    }

    @PostMapping("/{carId}/schedule-appointment")
    public String createNewAppointment(
        @Valid @ModelAttribute("appointment") Appointment appointment,
        BindingResult bindingResult,
        @PathVariable int carId
    ) {
        if (bindingResult.hasErrors()) {
            return "/appointments/create";
        }

        appointment.setCar(carService.getCar(carId));
        appointment.setStatus(AppointmentStatus.PENDING);
        appointment.setUser(userService.getCurrentLoggedUser());

        appointmentsService.create(appointment);

        return "redirect:/my-cars";
    }

    @GetMapping("/appointments/{appointmentId}/cancel")
    public String cancelAppointment(Model model, @PathVariable int appointmentId, HttpServletRequest request) {
        Appointment appointment = appointmentsService.getAppointment(appointmentId);
        appointmentsService.cancelAppointment(appointment);

        return "redirect:"+request.getHeader("Referer");
    }

    @GetMapping("/appointments/{appointmentId}/edit")
    public String showEditAppointmentForm(Model model, @PathVariable int appointmentId, HttpServletRequest request) {
        model.addAttribute("repairShops", repairShopService.getRepairShops());
        model.addAttribute("appointment", appointmentsService.getAppointment(appointmentId));
        model.addAttribute("carServices", carServiceService.getServices());

        return "/appointments/edit";
    }

    @PostMapping("/appointments/{appointmentId}/edit")
    public String updateAppointment(
        Model model,
        @PathVariable long appointmentId,
        @Valid @ModelAttribute("appointment") Appointment appointmentViewModel,
        BindingResult bindingResult
    ) {
        Appointment appointment = appointmentsService.getAppointment(appointmentId);
        appointment.setRepairShop(appointmentViewModel.getRepairShop());
        appointment.setDate(appointmentViewModel.getDate());
        appointment.setTime(appointmentViewModel.getTime());
        appointment.setServices(appointmentViewModel.getServices());

        if (bindingResult.hasErrors()) {
            model.addAttribute("appointment", appointment);
            return "/appointments/edit";
        }

        appointmentsService.updateAppointment(appointmentId, appointment);

        return "redirect:/my-cars/"+appointment.getCar().getId()+"/history";
    }
}

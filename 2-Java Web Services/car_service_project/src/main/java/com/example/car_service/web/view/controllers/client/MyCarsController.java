package com.example.car_service.web.view.controllers.client;

import com.example.car_service.data.entity.Car;
import com.example.car_service.data.entity.User;
import com.example.car_service.services.AppointmentsService;
import com.example.car_service.services.CarManufacturerService;
import com.example.car_service.services.CarService;
import com.example.car_service.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String UpdateCar(@PathVariable long id, @Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
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
}

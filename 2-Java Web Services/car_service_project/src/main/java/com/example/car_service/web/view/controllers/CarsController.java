package com.example.car_service.web.view.controllers;

import com.example.car_service.data.entity.Car;
import com.example.car_service.dto.CarDTO;
import com.example.car_service.dto.CreateCarDTO;
import com.example.car_service.services.CarManufacturerService;
import com.example.car_service.services.interfaces.CarManufacturerServiceInterface;
import com.example.car_service.services.interfaces.CarServiceInterface;
import com.example.car_service.web.view.model.CarListItemModel;
import com.example.car_service.web.view.model.CreateCarViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarsController {
    private final CarServiceInterface carService;
    private final CarManufacturerServiceInterface carManufacturerService;

    private final ModelMapper modelMapper;

    @GetMapping()
    public String getClientCars(Model model) {
        final List<Car> cars = this.carService.getCars();

        model.addAttribute("cars", cars);

        return "/cars/list";
    }

    @GetMapping("/create-car")
    public String showCreateCarForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("carManufacturers", this.carManufacturerService.getCarManufactures());

        return "/cars/create-car";
    }

    @PostMapping("/create")
    public String createCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/cars/create-car";
        }

        carService.create(car);

        return "redirect:/cars";
    }
//
//    @GetMapping("/edit-car/{id}")
//    public String showEditCarForm(Model model, @PathVariable Long id) {
//        model.addAttribute("car", carService.getCar(id));
//        model.addAttribute("carManufacturers", this.carManufacturerService.getCarManufactures());
//
//        return "/cars/edit-car";
//    }

//    @GetMapping("/client-cars/schedule-appointment/{carId}")
//    public String showScheduleAppointmentForm(Model model) {
//        model.addAttribute("school", new CreateSchoolViewModel());
//        return "/schools/create-school";
//    }

    private CarListItemModel convertToCarListItemModel(CarDTO carDTO) {
        return modelMapper.map(carDTO, CarListItemModel.class);
    }
}

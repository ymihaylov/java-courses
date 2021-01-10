package com.example.car_service.services;

import com.example.car_service.data.entity.Car;
import com.example.car_service.data.entity.User;
import com.example.car_service.data.repository.CarRepository;
import com.example.car_service.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car getCar(@Min(1) long id) {
        return carRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Invalid school Id: " + id));
    }

    public List<Car> getCarsByUser(User user) {
        return carRepository.findAllByUserId(user.getId());
    }

    public List<Car> getCars() {
        return this.carRepository.findAll();
    }

    public Car create(@Valid Car car) {
        return this.carRepository.save(car);
    }

    public Car updateCar(long id, Car car) {
        car.setId(id);
        return carRepository.save(car);
    }

    public void deleteSchool(long id) {
        carRepository.deleteById(id);
    }
}

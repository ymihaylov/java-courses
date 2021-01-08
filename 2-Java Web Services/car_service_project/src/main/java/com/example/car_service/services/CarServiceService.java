package com.example.car_service.services;

import com.example.car_service.data.entity.CarService;
import com.example.car_service.data.repository.CarServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceService {
    private final CarServiceRepository carServiceRepository;

    public List<CarService> getServices() {
        return this.carServiceRepository.findAll();
    }
}

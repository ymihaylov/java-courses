package com.example.car_service.services;

import com.example.car_service.data.entity.CarManufacturer;
import com.example.car_service.data.repository.CarManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManufacturerService {
    private final CarManufacturerRepository carManufacturerRepository;

    public List<CarManufacturer> getCarManufactures() {
        return this.carManufacturerRepository.findAll();
    }
}

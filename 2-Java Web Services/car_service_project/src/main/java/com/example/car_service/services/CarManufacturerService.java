package com.example.car_service.services;

import com.example.car_service.data.entity.CarManufacturer;
import com.example.car_service.data.repository.CarManufacturerRepository;
import com.example.car_service.services.interfaces.CarManufacturerServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManufacturerService implements CarManufacturerServiceInterface {
    private final CarManufacturerRepository carManufacturerRepository;

    @Override
    public List<CarManufacturer> getCarManufactures() {
        return this.carManufacturerRepository.findAll();
    }
}

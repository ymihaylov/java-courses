package com.example.car_service.data.repository;

import com.example.car_service.data.entity.CarManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarManufacturerRepository extends JpaRepository<CarManufacturer, Long> {
}

package com.example.car_service.data.repository;

import com.example.car_service.data.entity.CarService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarServiceRepository extends JpaRepository<CarService, Long> {

}

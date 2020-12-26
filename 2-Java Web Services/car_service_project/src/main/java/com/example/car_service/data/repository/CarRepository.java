package com.example.car_service.data.repository;

import com.example.car_service.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

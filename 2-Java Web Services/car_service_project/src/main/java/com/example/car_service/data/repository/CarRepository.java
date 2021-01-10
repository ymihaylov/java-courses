package com.example.car_service.data.repository;

import com.example.car_service.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    public List<Car> findAllByUserId(Long userId);
}

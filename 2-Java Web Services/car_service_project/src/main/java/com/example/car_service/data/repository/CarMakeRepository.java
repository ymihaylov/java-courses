package com.example.car_service.data.repository;

import com.example.car_service.data.entity.CarMake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarMakeRepository extends JpaRepository<CarMake, Long> {
}

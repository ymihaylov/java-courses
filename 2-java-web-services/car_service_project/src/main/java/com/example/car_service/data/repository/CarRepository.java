package com.example.car_service.data.repository;

import com.example.car_service.data.entity.Car;
import com.example.car_service.data.entity.RepairShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {
    List<Car> findAllByUserId(Long userId);

    @Query("SELECT distinct c from Car c inner join Appointment a ON a.car = c where a.repairShop = :repairShop")
    List<Car> peshoGosho(@Param("repairShop") RepairShop repairShop);
}

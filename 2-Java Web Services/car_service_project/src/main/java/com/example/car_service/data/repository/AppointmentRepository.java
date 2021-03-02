package com.example.car_service.data.repository;

import com.example.car_service.data.entity.Appointment;
import com.example.car_service.data.entity.AppointmentStatus;
import com.example.car_service.data.entity.RepairShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByCarIdOrderByDateDesc(Long carId);

    List<Appointment> findAllByStatusOrderByDateAsc(AppointmentStatus status);

    List<Appointment> findAllByRepairShopOrderByDateDesc(RepairShop repairShop);
}

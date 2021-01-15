package com.example.car_service.data.repository;

import com.example.car_service.data.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    public List<Appointment> findAllByCarIdOrderByDateDesc(Long carId);
}

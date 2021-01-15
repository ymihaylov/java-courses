package com.example.car_service.services;

import com.example.car_service.data.entity.Appointment;
import com.example.car_service.data.entity.Car;
import com.example.car_service.data.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentsService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsByCar(Car car) {
        return appointmentRepository.findAllByCarIdOrderByDateDesc(car.getId());
    }

    public Appointment create(@Valid Appointment appointment) {
        return this.appointmentRepository.save(appointment);
    }
}

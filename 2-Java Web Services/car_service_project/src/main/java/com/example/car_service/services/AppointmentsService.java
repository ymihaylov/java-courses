package com.example.car_service.services;

import com.example.car_service.data.entity.Appointment;
import com.example.car_service.data.entity.AppointmentStatus;
import com.example.car_service.data.entity.Car;
import com.example.car_service.data.entity.RepairShop;
import com.example.car_service.data.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentsService {
    private final AppointmentRepository appointmentRepository;

    public Appointment getAppointment(@Min(1) long id) {
        return appointmentRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Invalid appointment Id: " + id));
    }

    public List<Appointment> getAppointmentsByCar(Car car) {
        return appointmentRepository.findAllByCarIdOrderByDateDesc(car.getId());
    }

    public Appointment create(@Valid Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment cancelAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.CANCELLED);

        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(long id, Appointment appointment) {
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }

    private List<Appointment> getAppointmentsByStatus(AppointmentStatus status) {
        return appointmentRepository.findAllByStatusOrderByDateAsc(status);
    }

    public List<Appointment> getPendingAppointmentsByRepairShop(RepairShop repairShop) {
        return getAppointmentsByStatus(AppointmentStatus.PENDING)
                .stream()
                .filter(appointment -> appointment.getRepairShop().getId() == repairShop.getId())
                .collect(Collectors.toList());
    }
}

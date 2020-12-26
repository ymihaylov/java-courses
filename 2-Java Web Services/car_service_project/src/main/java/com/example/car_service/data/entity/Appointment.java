package com.example.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity {
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message="The date has to be in the past!")
    private LocalDate date;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "car_service_company_id")
    private CarServiceCompany carServiceCompany;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "appointments_services",
        joinColumns = { @JoinColumn(name = "appointment_id") },
        inverseJoinColumns = { @JoinColumn(name = "service_id") }
    )
    Set<CarService> services = new HashSet<>();
}

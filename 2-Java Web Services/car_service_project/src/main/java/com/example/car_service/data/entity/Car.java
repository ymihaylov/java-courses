package com.example.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String model;
    private String registration;
    private int year;

    @ManyToOne
    @JoinColumn(name = "car_manufacturer_id")
    private CarManufacturer carManufacturer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public String getFullName() {
        return this.getCarManufacturer().getName() + " "
                + this.getModel() + " "
                + this.getRegistration();
    }
}

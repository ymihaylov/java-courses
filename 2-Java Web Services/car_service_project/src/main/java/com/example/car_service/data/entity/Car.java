package com.example.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String model;
    private String registrationNumber;
    private int year;

    @ManyToOne
    @JoinColumn(name = "car_manufacturer_id")
    private CarManufacturer carManufacturer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

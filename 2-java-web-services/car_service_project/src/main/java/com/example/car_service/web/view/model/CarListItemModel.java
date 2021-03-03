package com.example.car_service.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarListItemModel {
    private long id;
    private String make;
    private String model;
    private String registrationNumber;
    private int year;
}

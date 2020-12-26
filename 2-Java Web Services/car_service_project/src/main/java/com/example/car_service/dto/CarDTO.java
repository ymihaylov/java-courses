package com.example.car_service.dto;

import com.example.car_service.data.entity.CarManufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {
    private long id;
    private String make;
    private String model;
    private String registrationNumber;
    private int year;
    private CarManufacturer carManufacturer;

//    @NotBlank
//    private String model;
//
//    @NotBlank
//    @Pattern(regexp="^\\p{L}{2}\\d{4}\\p{L}{2}$",message="Invalid format")
//    private String registrationNumber;
//
//    private CarManufacturer carManufacturer;
//
//    @Range(min=1960, max=2021)
//    private int year;
}


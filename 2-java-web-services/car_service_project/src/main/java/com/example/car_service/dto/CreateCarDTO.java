package com.example.car_service.dto;

import com.example.car_service.data.entity.CarManufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateCarDTO {
    @NotBlank
    private String model;

    @NotBlank
    @Pattern(regexp="^\\p{L}{2}\\d{4}\\p{L}{2}$", message="Invalid format")
    private String registrationNumber;

    private CarManufacturer carManufacturer;

    @Range(min=1960, max=2021)
    private int year;
}

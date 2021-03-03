package com.example.car_service.web.view.model;

import com.example.car_service.data.entity.CarManufacturer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class CreateCarViewModel {
    @NotBlank
    private String model;

    @NotBlank
    private int registrationNumber;

    @NotBlank
    @Size(min = 1960, max = 2021, message="Min 1960, Max 2021")
    private int yearOfManufacture;

    @NotBlank
    private CarManufacturer carManufacturer;
}

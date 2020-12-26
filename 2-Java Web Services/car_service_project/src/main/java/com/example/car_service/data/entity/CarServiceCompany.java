package com.example.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "car_service_companies")
public class CarServiceCompany extends BaseEntity {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "car_service_company_to_manufacturers",
        joinColumns = { @JoinColumn(name = "car_service_company_id") },
        inverseJoinColumns = { @JoinColumn(name = "car_manufacturer_id") }
    )
    Set<CarManufacturer> supportedManufacturers = new HashSet<>();
}

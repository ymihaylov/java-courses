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
@Table(name = "repair_shops")
public class RepairShop extends BaseEntity {
    private String name;

    @OneToMany
    private Set<User> employees;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "repair_shops_manufacturers",
        joinColumns = { @JoinColumn(name = "repair_shop_id") },
        inverseJoinColumns = { @JoinColumn(name = "car_manufacturer_id") }
    )
    Set<CarManufacturer> supportedManufacturers = new HashSet<>();
}

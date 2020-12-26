package com.example.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "car_manufacturers")
public class CarManufacturer extends BaseEntity {
    @Size(max = 20, message="Max 20")
    private String name;
}

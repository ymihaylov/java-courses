package com.example.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Where(clause = "deleted = 0")
@Table(name = "cars")
public class Car extends BaseEntity {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String make;

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String model;
}

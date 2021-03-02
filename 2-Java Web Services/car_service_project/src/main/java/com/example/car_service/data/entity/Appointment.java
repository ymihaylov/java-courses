package com.example.car_service.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@DynamicUpdate
@Table(name = "appointments")
public class Appointment extends BaseEntity {
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Future(message="The date has to be in the future!")
    private LocalDate date;

    @NotNull
    private String time;

    @Column
    private BigDecimal price;
 
    @Enumerated
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "repair_shop_id")
    private RepairShop repairShop;

    @ManyToMany(cascade = { CascadeType.ALL })
    Set<CarService> services = new HashSet<>();
}

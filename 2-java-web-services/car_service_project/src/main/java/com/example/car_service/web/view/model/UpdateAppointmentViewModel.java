package com.example.car_service.web.view.model;

import com.example.car_service.data.entity.CarService;
import com.example.car_service.data.entity.RepairShop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAppointmentViewModel {
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Future(message="The date has to be in the future!")
    private LocalDate date;

    @NotNull
    private String time;

    @ManyToOne
    @JoinColumn(name = "repair_shop_id")
    private RepairShop repairShop;

    @ManyToMany(cascade = { CascadeType.ALL })
    Set<CarService> services = new HashSet<>();
}

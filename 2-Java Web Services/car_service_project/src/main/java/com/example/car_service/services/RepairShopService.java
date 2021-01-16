package com.example.car_service.services;

import com.example.car_service.data.entity.Car;
import com.example.car_service.data.entity.RepairShop;
import com.example.car_service.data.entity.User;
import com.example.car_service.data.repository.RepairShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.List;

@Service
@AllArgsConstructor
public class RepairShopService {
    private final RepairShopRepository repairShopRepository;
    private final UserService userService;

    public List<RepairShop> getRepairShops() {
        return this.repairShopRepository.findAll();
    }

    public RepairShop getRepairShop(@Min(1) long id) {
        return repairShopRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid repair shop Id: " + id));
    }

    public RepairShop getCurrentRepairShopByLoggedUser() {
        User user = userService.getCurrentLoggedUser();
        return user.getRepairShop();
    }
}

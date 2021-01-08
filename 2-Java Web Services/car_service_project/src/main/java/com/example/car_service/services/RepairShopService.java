package com.example.car_service.services;

import com.example.car_service.data.entity.RepairShop;
import com.example.car_service.data.repository.RepairShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RepairShopService {
    private final RepairShopRepository repairShopRepository;

    public List<RepairShop> getRepairShops() {
        return this.repairShopRepository.findAll();
    }
}

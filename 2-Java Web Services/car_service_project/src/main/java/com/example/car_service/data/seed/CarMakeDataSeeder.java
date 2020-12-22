package com.example.car_service.data.seed;

import com.example.car_service.data.entity.CarMake;
import com.example.car_service.data.repository.CarMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarMakeDataSeeder implements CommandLineRunner {
    @Autowired
    CarMakeRepository carMakeRepository;

    @Override
    public void run(String... args) throws Exception {
        CarMake carMake = new CarMake();
        carMake.setName("Audi");
        this.carMakeRepository.save(carMake);
    }
}

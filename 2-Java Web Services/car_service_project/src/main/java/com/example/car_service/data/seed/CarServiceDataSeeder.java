package com.example.car_service.data.seed;

import com.example.car_service.data.entity.CarService;
import com.example.car_service.data.repository.CarServiceRepository;
import com.example.car_service.utils.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarServiceDataSeeder implements CommandLineRunner {
    @Autowired
    private CarServiceRepository carServiceRepository;

    @Autowired
    private CsvReader csvReader;

    @Override
    public void run(String... args) throws Exception {
        if (this.carServiceRepository.count() > 0) {
            return;
        }

        this.csvReader.readFile("data_seeds/car_services.csv").forEach((row) -> {
            CarService carService = new CarService();
            carService.setName(row.get(0));
            this.carServiceRepository.save(carService);
        });
    }
}

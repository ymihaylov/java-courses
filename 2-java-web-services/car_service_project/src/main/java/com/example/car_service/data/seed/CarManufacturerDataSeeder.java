package com.example.car_service.data.seed;

import com.example.car_service.utils.CsvReader;
import com.example.car_service.data.entity.CarManufacturer;
import com.example.car_service.data.repository.CarManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarManufacturerDataSeeder implements CommandLineRunner {
    @Autowired
    private CarManufacturerRepository carManufacturerRepository;

    @Autowired
    private CsvReader csvReader;

    @Override
    public void run(String... args) throws Exception {
        if (this.carManufacturerRepository.count() > 0) {
            return;
        }

        this.csvReader.readFile("data_seeds/car_manufacturers.csv").forEach((row) -> {
            CarManufacturer carManufacturer = new CarManufacturer();
            carManufacturer.setName(row.get(0));
            this.carManufacturerRepository.save(carManufacturer);
        });
    }
}

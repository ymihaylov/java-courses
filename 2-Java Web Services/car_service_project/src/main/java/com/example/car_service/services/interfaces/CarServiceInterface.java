package com.example.car_service.services.interfaces;

import com.example.car_service.data.entity.Car;



import java.util.List;

public interface CarServiceInterface {
    Car create(Car car);

    List<Car> getCars();
}

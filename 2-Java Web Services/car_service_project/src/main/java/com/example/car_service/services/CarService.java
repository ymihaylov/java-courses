package com.example.car_service.services;

import com.example.car_service.data.entity.Car;
import com.example.car_service.data.repository.CarRepository;
import com.example.car_service.dto.CarDTO;
import com.example.car_service.dto.CreateCarDTO;
import com.example.car_service.services.interfaces.CarServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService implements CarServiceInterface {
    private final CarRepository carRepository;

    private final ModelMapper modelMapper;

//    @Override
//    public CarDTO getCar(@Min(1) long id) {
//        return modelMapper.map(carRepository.findById(id), Create.class);
//    }

    @Override
    public List<Car> getCars() {
        return this.carRepository.findAll();
    }

    @Override
    public Car create(@Valid Car car) {
        return this.carRepository.save(car);
    }

//    private CarDTO convertToCarDTO(Car car) {
//        return modelMapper.typeMap(Car.class, CarDTO.class).addMappings(mapper -> {
//            mapper.map(src -> src.getCarManufacturer().getName(), CarDTO::setModel);
//        }).map(car);
//    }
}

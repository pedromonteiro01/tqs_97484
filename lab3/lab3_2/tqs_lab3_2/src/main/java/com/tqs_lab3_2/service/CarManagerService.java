package com.tqs_lab3_2.service;

import java.util.List;
import java.util.Optional;

import com.tqs_lab3_2.data.Car;
import com.tqs_lab3_2.data.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarManagerService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Optional<Car> getCarDetails(Long carId){
        Car car = carRepository.findByCarId(carId);
        if (car != null)
            return Optional.of(car);

        return Optional.empty();
    }
    
}

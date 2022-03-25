package com.tqs_lab3_2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarManagerService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car car){
        return null;
    }

    public List<Car> getAllCars(){
        return null;
    }

    public Optional<Car> getCarDetails(Long car){
        return null;
    }
    
}

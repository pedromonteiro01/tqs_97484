package com.tqs_lab3_2.boundary;

import java.util.List;

import com.tqs_lab3_2.data.Car;
import com.tqs_lab3_2.service.CarManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarManagerService carManagerService;

    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return new ResponseEntity<Car>(carManagerService.save(car), HttpStatus.CREATED);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carManagerService.getAllCars();
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        return ResponseEntity.of(carManagerService.getCarDetails(carId));
    }
}

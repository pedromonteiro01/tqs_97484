package com.tqs_lab3_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarManagerService carManagerService;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return null;
    }

    @GetMapping("/all-cars")
    public List<Car> getAllCars(){
        return null;
    }

    @GetMapping("/car-by-id")
    public ResponseEntity<Car> getCarById(@RequestParam(name = "carId") Long carId) {
        return null;
    }
    
}

package com.tqs_lab3_2.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.tqs_lab3_2.data.Car;
import com.tqs_lab3_2.data.CarRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarManagerServiceTest {

    @Mock(lenient = true)
    private CarRepository carRepository;
  
    @InjectMocks
    private CarManagerService carManagerService;

    // car variables to be used by test functions
    Car c1 = new Car("car1", "m1");
    Car c2 = new Car("car2", "m2");
    Car c3 = new Car("car3", "m3");

    @BeforeEach
    public void setUp() {
        List<Car> allCars = Arrays.asList(c1, c2, c3);

        Mockito.when(carRepository.save(c1)).thenReturn(c1);
        Mockito.when(carRepository.findAll()).thenReturn(allCars);
        Mockito.when(carRepository.findByCarId(c1.getCarId())).thenReturn(c1);
        Mockito.when(carRepository.findByCarId(c2.getCarId())).thenReturn(c2);
        Mockito.when(carRepository.findByCarId(c3.getCarId())).thenReturn(c3);
    }

    @Test
    public void testReturnCar() {
        assertThat(carManagerService.save(c1).getModel()).isEqualTo("m1");
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).save(c1);
    }

    @Test
    public void testReturnAllCars() {
        List<Car> allCars = carManagerService.getAllCars();

        // check if size is equal to number of cars
        assertThat(allCars.size()).isEqualTo(3);

        assertThat(allCars.get(0).getModel()).isEqualTo("m1");
        assertThat(allCars.get(1).getModel()).isEqualTo("m2");
        assertThat(allCars.get(2).getModel()).isEqualTo("m3");

        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findAll();
    }

    @Test
    public void testCarNotExists() {
        assertThat(carManagerService.getCarDetails(-1000L)).isEmpty();
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByCarId(-1000L);
    }
    
}

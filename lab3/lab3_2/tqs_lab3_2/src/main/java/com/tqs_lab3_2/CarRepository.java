package com.tqs_lab3_2;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository {
    public Car findByCarId(Long cardId);
    public List<Car> finAll();
}

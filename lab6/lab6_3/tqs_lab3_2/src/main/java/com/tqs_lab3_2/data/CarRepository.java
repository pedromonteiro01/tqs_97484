package com.tqs_lab3_2.data;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findByCarId(Long cardId);
    public List<Car> findAll();
}

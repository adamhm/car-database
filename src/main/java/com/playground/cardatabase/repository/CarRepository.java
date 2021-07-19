package com.playground.cardatabase.repository;

import com.playground.cardatabase.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    
    List<Car> findByBrand(String brand);
    
    List<Car> findByColor(String color);
    
    List<Car> findByYear(int year);
}

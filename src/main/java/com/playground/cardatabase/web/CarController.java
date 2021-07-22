package com.playground.cardatabase.web;

import com.playground.cardatabase.domain.Car;
import com.playground.cardatabase.repository.CarRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository carRepository;
    
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    
    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }
}

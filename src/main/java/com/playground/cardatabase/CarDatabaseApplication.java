package com.playground.cardatabase;

import com.playground.cardatabase.domain.Car;
import com.playground.cardatabase.domain.Owner;
import com.playground.cardatabase.repository.CarRepository;
import com.playground.cardatabase.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarDatabaseApplication {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    
    public CarDatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(CarDatabaseApplication.class, args);
    }
    
    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Add owners
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");
            ownerRepository.saveAll(List.of(owner1, owner2));
            
            // Add cars
            
            carRepository.save(new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2017, 59000, owner1));
            carRepository.save(new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2014, 29000, owner2));
            carRepository.save(new Car("Toyota", "Prius", "Silver",
                "KKO-0212", 2018, 39000, owner2));
        };
    }
}

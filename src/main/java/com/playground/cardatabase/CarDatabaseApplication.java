package com.playground.cardatabase;

import com.playground.cardatabase.domain.Car;
import com.playground.cardatabase.domain.Owner;
import com.playground.cardatabase.domain.User;
import com.playground.cardatabase.repository.CarRepository;
import com.playground.cardatabase.repository.OwnerRepository;
import com.playground.cardatabase.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarDatabaseApplication {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final UserRepository userRepository;
    
    public CarDatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository,
                                  UserRepository userRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
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

            // Add users
            // user - user
            userRepository.save(new User("user",
                "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
                "USER"));
            // admin - admin
            userRepository.save(new User("admin",
                "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                "ADMIN"));
        };
    }
}

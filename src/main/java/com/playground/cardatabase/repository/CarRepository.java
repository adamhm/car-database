package com.playground.cardatabase.repository;

import com.playground.cardatabase.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

}

package com.example.demo.Services.MainClasses.repos;

import com.example.demo.Services.MainClasses.CarInfo.Car;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepo extends CrudRepository<Car, String> {
    List<Car> getAllCarByStatus(CarStatus status);

    List<Car> getCatByName(String name);

    List<Car> getCarByCarId(UUID carId);


}

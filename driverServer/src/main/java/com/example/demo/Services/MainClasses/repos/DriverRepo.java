package com.example.demo.Services.MainClasses.repos;

import com.example.demo.Services.MainClasses.DriverInfo.Driver;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface DriverRepo extends CrudRepository<Driver, String> {

    List<Driver> getAllByStatus(DriverStatus status);

    List<Driver> getByName(String name);

    List<Driver> getByDriverId(UUID driverId);
}

package com.example.demo.Services.ServicesRealization;

import com.example.demo.Services.MainClasses.DriverInfo.Category;
import com.example.demo.Services.MainClasses.DriverInfo.Driver;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import com.example.demo.Services.MainClasses.repos.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonnelService {

    private final DriverRepo repos;

    @Autowired
    public PersonnelService(DriverRepo repos) {
        this.repos = repos;
    }

    public void changeDriversMileage(UUID driverId, double additionMileage) {

        List<Driver> list = repos.getByDriverId(driverId);
        if (list.isEmpty())
            return;
        Driver driver = list.get(0);
        double newMileage = driver.getMileage() + additionMileage;
        driver.setMileage(newMileage);
        repos.save(driver);
    }

    public void changeDriverStatus(UUID driverId, DriverStatus stat) {

        List<Driver> list = repos.getByDriverId(driverId);
        if (list.isEmpty())
            return;
        Driver driver = list.get(0);
        driver.setStatus(stat);
        repos.save(driver);
    }

    public void changeDriversQualities(UUID driverId) {

        List<Driver> list = repos.getByDriverId(driverId);
        if (list.isEmpty())
            return;
        Driver driver = list.get(0);
        if (driver.getMileage() < 1000) {

            driver.setCategory(Category.A);
            driver.setSalary((1000));
            repos.save(driver);

        } else if (driver.getMileage() < 2000) {

            driver.setCategory(Category.B);
            driver.setSalary(driver.getSalary() + 1000);
            repos.save(driver);

        } else if (driver.getMileage() < 3000) {

            driver.setCategory(Category.C);
            driver.setSalary(driver.getSalary() + 1000);
            repos.save(driver);

        } else if (driver.getMileage() < 4000) {

            driver.setCategory(Category.D);
            driver.setSalary(driver.getSalary() + 1000);
            repos.save(driver);

        } else return;
    }

    public Driver updateDriverInformation(UUID driverId, double additionMileage) {

        List<Driver> list = repos.getByDriverId(driverId);

        if (list.isEmpty())
            return null;

        Driver driver = list.get(0);
        this.changeDriversMileage(driver.getDriverId(), additionMileage);
        this.changeDriversQualities(driver.getDriverId());
        this.changeDriverStatus(driver.getDriverId(), DriverStatus.atWork);
        repos.save(driver);
        return driver;

    }

    public Driver addNewDriverToPersonnel(String name, Category category,
                                          double salary, double mileage) {
        Driver driver = new Driver(name, category, salary, mileage);
        repos.save(driver);
        return driver;

    }


    public List<Driver> getDriversByStatus(DriverStatus status) {
        return repos.getAllByStatus(status);
    }

    public List<Driver> getDriverById(UUID id) {
        List<Driver> list = repos.getByDriverId(id);

        if (list.isEmpty())
            return null;

        return list;
    }

    public boolean deleteOperation(List<Driver> list) {
        if (list.size() == 0) return false;
        int iterator = 0;
        int iterationSize = list.size();

        for (iterator = 0; iterator < iterationSize; iterator++) {

            repos.delete(list.get(iterator));
        }
        return true;
    }

    public boolean deleteAllDriverByName(String name) {

        List<Driver> list = repos.getByName(name);
        return deleteOperation(list);
    }

    public boolean deleteAllDriverByStatus(DriverStatus status) {

        List<Driver> list = repos.getAllByStatus(status);
        return deleteOperation(list);
    }

    public boolean deleteAllDrivers() {
        List<Driver> list = (List<Driver>) repos.findAll();
        return deleteOperation(list);
    }


    public List<Driver> driversReport() {
        return (List<Driver>) repos.findAll();
    }
}


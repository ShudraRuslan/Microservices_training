package com.example.demo.Services.ServicesRealization;

import com.example.demo.Services.MainClasses.CarInfo.Car;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import com.example.demo.Services.MainClasses.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CarService {

    private final CarRepo repos;

    @Autowired
    public CarService(CarRepo repos) {
        this.repos = repos;
    }

    public void changeCarMileage(UUID carId, double additionMileage) {
        List<Car> list = repos.getCarByCarId(carId);
        if (list.isEmpty())
            return;
        Car car = list.get(0);
        double newMileage = car.getMileage() + additionMileage;
        car.setMileage(newMileage);
        repos.save(car);
    }

    public void changeCarStatus(UUID carId, CarStatus stat) {
        List<Car> list = repos.getCarByCarId(carId);
        if (list.isEmpty())
            return;
        Car car = list.get(0);
        car.setStatus(stat);
        repos.save(car);
    }


    public void changeCarQualities(UUID carId) {
        List<Car> list = repos.getCarByCarId(carId);
        if (list.isEmpty())
            return;
        Car car = list.get(0);
        if (car.getMileage() >= 4000) {

            car.setStatus(CarStatus.isAtService);
            car.setMileage(0);
        }
        System.out.println("Change car qualities! ");
        repos.save(car);
    }

    public Car addNewCarToCarPark(String name, double enginePower,
                                  int capacity, double fuelConsumption, double mileage) {
        Car car = new Car(name, enginePower, capacity, fuelConsumption, mileage);
        System.out.println("Adding new car!");
        repos.save(car);
        return car;
    }

    public Car updateCarInformation(UUID carId, double additionMileage) {
        List<Car> list = repos.getCarByCarId(carId);
        if (list.isEmpty())
            return null;
        Car car = list.get(0);
        this.changeCarStatus(car.getCarID(), CarStatus.isAtWork);
        this.changeCarMileage(car.getCarID(), additionMileage);
        this.changeCarQualities(car.getCarID());
        System.out.println("Updating information!");
        repos.save(car);
        return car;
    }

   
    public List<Car> getCarsByStatus(CarStatus status) {
        return repos.getAllCarByStatus(status);
    }

    public List<Car> getCarById(UUID id) {

        List<Car> list = repos.getCarByCarId(id);
        if (list.isEmpty())
            return null;

        return list;
    }

    public boolean deleteOperation(List<Car> list) {
        if (list.size() == 0) return false;
        int iterator = 0;
        int iterationSize = list.size();

        for (iterator = 0; iterator < iterationSize; iterator++) {
            repos.delete(list.get(iterator));
        }
        return true;
    }

    public boolean deleteAllCarByName(String name) {
        List<Car> list = repos.getCatByName(name);
        return deleteOperation(list);
    }

    public boolean deleteAllCarByStatus(CarStatus status) {
        List<Car> list = repos.getAllCarByStatus(status);
        return deleteOperation(list);
    }

    public boolean deleteAllCars() {
        List<Car> list = (List<Car>) repos.findAll();
        return deleteOperation(list);
    }


    public List<Car> carsReport() {
        return (List<Car>) repos.findAll();
    }
}

package com.example.demo.Services.MainClasses.CarInfo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@EnableAutoConfiguration
public class Car {
    @Id
    private UUID carId;
    private String name;
    private double enginePower;
    private int capacity;
    private double fuelConsumption;
    private double mileage;
    private CarStatus status;

    public Car(String name, double enginePower, int capacity, double fuelConsumption, double mileage) {
        this.carId = UUID.randomUUID();
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.name = name;
        this.mileage = mileage;
        this.status = CarStatus.isFree;

    }

    public Car() {
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public double getMileage() {
        return mileage;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getCarID() {
        return carId;
    }

    public void setCarID(UUID carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "CarId is " + carId + " CarName is " + name + " car status is " + status +
                " CarMileage is " + mileage + " CarFuelConsumption is " + fuelConsumption;
    }


}

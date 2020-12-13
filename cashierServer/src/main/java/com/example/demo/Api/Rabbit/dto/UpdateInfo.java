package com.example.demo.Api.Rabbit.dto;

public class UpdateInfo {
    private final double distance;
    private final double carFuelConsumption;
    private final int amountOfPassengers;
    private final double driverSalary;
    private final boolean carNeedsService;
    private final boolean isVip;

    public UpdateInfo(double distance, double carFuelConsumption,
                      int amountOfPassengers, double driverSalary,
                      boolean carNeedsService, boolean isVip) {
        this.distance = distance;
        this.carFuelConsumption = carFuelConsumption;
        this.amountOfPassengers = amountOfPassengers;
        this.driverSalary = driverSalary;
        this.carNeedsService = carNeedsService;
        this.isVip = isVip;
    }

    public double getDistance() {
        return distance;
    }

    public double getCarFuelConsumption() {
        return carFuelConsumption;
    }

    public int getAmountOfPassengers() {
        return amountOfPassengers;
    }

    public double getDriverSalary() {
        return driverSalary;
    }

    public boolean isCarNeedsService() {
        return carNeedsService;
    }

    public boolean isVip() {
        return isVip;
    }
}

package com.example.demo.Api.Rabbit.carDto;

public class CreateInfo {
    private final String name;
    private final double enginePower;
    private final int capacity;
    private final double fuelConsumption;
    private final double mileage;

    public CreateInfo(String name, double enginePower, int capacity, double fuelConsumption, double mileage) {
        this.name = name;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.mileage = mileage;
    }

    public String getName() {
        return name;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getMileage() {
        return mileage;
    }
}

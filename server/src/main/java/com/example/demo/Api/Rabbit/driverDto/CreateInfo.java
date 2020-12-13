package com.example.demo.Api.Rabbit.driverDto;

import com.example.demo.Services.MainClasses.DriverInfo.Category;

public class CreateInfo {
    private final String name;
    private final Category category;
    private final double salary;
    private final double mileage;

    public CreateInfo(String name, Category category, double salary, double mileage) {
        this.name = name;
        this.category = category;
        this.salary = salary;
        this.mileage = mileage;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getSalary() {
        return salary;
    }

    public double getMileage() {
        return mileage;
    }
}

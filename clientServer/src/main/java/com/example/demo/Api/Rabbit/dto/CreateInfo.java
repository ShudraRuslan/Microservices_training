package com.example.demo.Api.Rabbit.dto;

public class CreateInfo {
    private final String name;
    private final double cash;
    private final boolean isVip;

    public CreateInfo(String name, double cash, boolean isVip) {
        this.name = name;
        this.cash = cash;
        this.isVip = isVip;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public boolean isVip() {
        return isVip;
    }
}

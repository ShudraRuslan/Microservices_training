package com.example.demo.Services.MainClasses.ClientInfo;


import java.util.UUID;

public class Client {
    private UUID clientId;
    private String name;
    private double cash;
    private boolean isVip;

    public Client() {
    }

    public Client(String name, double cash, boolean isVip) {
        this.name = name;
        this.cash = cash;
        this.isVip = isVip;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    @Override
    public String toString() {
        return "Name is'" + name +
                " isVip " + isVip;
    }
}

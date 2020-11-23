package com.example.demo.Services.MainClasses.ClientInfo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Client {
    @Id
    UUID clientId;
    private String name;
    private double cash;
    private boolean isVip;

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public Client() {

    }

    public Client(String name, double cash, boolean isVip) {
        this.clientId = UUID.randomUUID();
        this.name = name;
        this.cash = cash;
        this.isVip = isVip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public void setVip(boolean vip) {
        isVip = vip;
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


    @Override
    public String toString() {
        return "Name is'" + name +
                " isVip " + isVip;
    }
}

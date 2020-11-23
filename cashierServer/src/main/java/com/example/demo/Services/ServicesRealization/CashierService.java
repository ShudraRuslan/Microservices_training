package com.example.demo.Services.ServicesRealization;

import com.example.demo.Services.MainClasses.CashierInfo.Cashier;
import com.example.demo.Services.MainClasses.repos.CashierRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CashierService {

    private final CashierRepo repos;


    public CashierService(CashierRepo repos) {
        this.repos = repos;
    }

    public Cashier createCashier(String name) {
        if (repos.getByName(name) != null)

            return repos.getByName(name);

        else {

            Cashier cashier = new Cashier(name);
            repos.save(cashier);
            return cashier;
        }
    }

    public void changeFuelLoses(double distance, double consumption) {
        Cashier cashier = repos.getByName("cash");
        double additionFuelLoses = distance * consumption;
        double newFuelLoses = cashier.getFuelCash() + additionFuelLoses;
        cashier.setFuelCash(newFuelLoses);
        repos.save(cashier);
    }

    public double getCurrentBookingCash(double distance, int amountOfPassengers, boolean isVipClient) {
        if (isVipClient)

            return (10 * distance + 5 * amountOfPassengers) * 0.2;

        else
            return 10 * distance + 5 * amountOfPassengers;
    }

    public void changeBookingCash(double distance, int amountOfPassengers, boolean isVipClient) {

        Cashier cashier = repos.getByName("cash");
        double additionOrderPrice = 100 * distance + 5 * amountOfPassengers;
        double newBookingCash = cashier.getBookingCash() + additionOrderPrice;
        if (isVipClient)

            newBookingCash *= 0.2;

        cashier.setBookingCash(newBookingCash);
        repos.save(cashier);
    }

    public void changeCarServiceCash() {

        Cashier cashier = repos.getByName("cash");
        double newServiceCash = cashier.getCarServiceCash() + 4000;
        cashier.setCarServiceCash(newServiceCash);
        repos.save(cashier);
    }

    public void changeDriverSalaryCash(double salary) {

        Cashier cashier = repos.getByName("cash");
        double newDriverSalaryCash = cashier.getDriverSalaryCash() + salary;
        cashier.setDriverSalaryCash(newDriverSalaryCash);
        repos.save(cashier);
    }

    public void countCashierBalance() {

        Cashier cashier = repos.getByName("cash");
        double additionBalance = cashier.getBookingCash() - cashier.getCarServiceCash() -
                cashier.getDriverSalaryCash() - cashier.getFuelCash();

        double balance = cashier.getBalance() + additionBalance;
        cashier.setBalance(balance);
        repos.save(cashier);
    }

    public Cashier updateCashier(double distance, double consumption, int amountOfPassengers,
                                 double salary, boolean needsService, boolean isVip) {
        Cashier cashier = repos.getByName("cash");

        changeFuelLoses(distance, consumption);
        changeDriverSalaryCash(salary);
        changeBookingCash(distance, amountOfPassengers, isVip);
        if (needsService)

            changeCarServiceCash();

        countCashierBalance();
        repos.save(cashier);
        return cashier;
    }

    public Cashier getById(UUID id) {
        return repos.getById(id);

    }

    public String cashierReport() {

        Cashier cashier = repos.getByName("cash");
        String report = cashier.toString();
        return report;
    }

}

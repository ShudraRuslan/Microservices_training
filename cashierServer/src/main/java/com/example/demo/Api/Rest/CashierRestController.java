package com.example.demo.Api.Rest;

import com.example.demo.Services.MainClasses.CashierInfo.Cashier;
import com.example.demo.Services.ServicesRealization.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cashier")
public class CashierRestController {
    private final CashierService service;

    @Autowired
    public CashierRestController(CashierService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Cashier> create(@RequestParam String name) {

        return ResponseEntity.ok(service.createCashier(name));
    }

    @GetMapping
    public ResponseEntity<String> report() {
        return ResponseEntity.ok(service.cashierReport());
    }

    @GetMapping("/bookingCash")
    public ResponseEntity<Double> getCurrantBookingCash(@RequestParam double distance, @RequestParam int amountOfPassengers,
                                                        @RequestParam boolean isVip) {
        return ResponseEntity.ok(service.getCurrentBookingCash(distance, amountOfPassengers, isVip));
    }

    @PutMapping
    public ResponseEntity<Cashier> updateInfo(@RequestParam double distance, @RequestParam double carFuelConsumption,
                                              @RequestParam int amountOfPassengers, @RequestParam double driverSalary,
                                              @RequestParam boolean carNeedsService, @RequestParam boolean isVip) {
        return ResponseEntity.ok(service.updateCashier(distance, carFuelConsumption,
                amountOfPassengers, driverSalary, carNeedsService, isVip));
    }
}

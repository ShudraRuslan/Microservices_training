package com.example.demo.Api.Rest;

import com.example.demo.Services.MainClasses.CarInfo.Car;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import com.example.demo.Services.MainClasses.CashierInfo.Cashier;
import com.example.demo.Services.MainClasses.ClientInfo.Client;
import com.example.demo.Services.MainClasses.DriverInfo.Driver;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import com.example.demo.Services.MainClasses.OrderInfo.Order;
import com.example.demo.Services.MainClasses.OrderInfo.OrderStatus;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(value = "/order")
public class OrderRestController {

    private final RestTemplate template = new RestTemplate();


    private Client getOrderClient(UUID clientId) {

        String address = "http://clientserver:8085/client/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("module", MappingModule.byId).
                queryParam("id", clientId);

        HttpEntity<Client> response = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                Client.class);
        return response.getBody();
    }

    private Driver getOrderDriver(UUID driverId) {

        String address = "http://driverserver:8086/personnel/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("status", DriverStatus.defaultStat).
                queryParam("id", driverId).
                queryParam("module", MappingModule.byId);

        HttpEntity<Driver> response = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                Driver.class);
        return response.getBody();
    }

    private Car getOrderCar(UUID carId) {

        String address = "http://carserver:8083/car/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("status", CarStatus.defaultStat).
                queryParam("id", carId).
                queryParam("module", MappingModule.byId);

        HttpEntity<Car> response = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                Car.class);
        return response.getBody();

    }


    private void checkClientsPayAbility(Order order, double distance,
                                        int amountOfPassengers, boolean isVip) {

        String address = "http://cashierserver:8084/cashier/bookingCash";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("distance", distance).
                queryParam("amountOfPassengers", amountOfPassengers).
                queryParam("isVip", isVip);
        HttpEntity<Double> firstResponse = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                Double.class);
        double payload = firstResponse.getBody();


        Client cLient = getOrderClient(order.getClientId());
        boolean haveEnoughMoney = cLient.getCash() >= payload;

        if (haveEnoughMoney) {

            System.out.println("CLIENT DOES NOT HAVE ENOUGH MONEY!");
            order.setStatus(OrderStatus.isCancelled);

        }
    }

    private Car updateCarInformation(UUID carId, double distance) {

        String address = "http://carserver:8083/car/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", carId).
                queryParam("distance", distance);
        HttpEntity<Car> response = template.exchange(builder.toUriString(), HttpMethod.PUT, null, Car.class);
        return response.getBody();
    }

    private Driver updateDriverInformation(UUID driverId, double distance) {

        String address = "http://driverserver:8086/personnel/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", driverId).
                queryParam("distance", distance);
        HttpEntity<Driver> response = template.exchange(builder.toUriString(), HttpMethod.PUT, null, Driver.class);
        return response.getBody();
    }

    private Cashier updateCashier(double distance, double carFuelConsumption,
                                  int amountOfPassengers, double driverSalary,
                                  boolean carNeedsService, boolean isVip) {

        String address = "http://cashierserver:8082/cashier/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("distance", distance).
                queryParam("carFuelConsumption", carFuelConsumption).
                queryParam("amountOfPassengers", amountOfPassengers).
                queryParam("driverSalary", driverSalary).
                queryParam("carNeedsService", carNeedsService).
                queryParam("isVip", isVip);
        HttpEntity<Cashier> response = template.exchange(builder.toUriString(), HttpMethod.PUT, null, Cashier.class);
        return response.getBody();
    }

    private void updateInformation(Order order) {

        if (order.getStatus() == OrderStatus.isCompleted) {

            Driver driver = getOrderDriver(order.getDriverId());
            Car car = getOrderCar(order.getCarId());

            double distance = order.getDistance();
            int amountOfPassengers = order.getAmountOfPassengers();
            boolean isVip = getOrderClient(order.getClientId()).isVip();
            double carFuelConsumption = car.getFuelConsumption();
            double driverSalary = driver.getSalary();
            boolean carNeedsService = car.getMileage() > 4000;


            updateDriverInformation(order.getDriverId(), distance);
            updateCarInformation(order.getCarId(), distance);
            updateCashier(distance, carFuelConsumption,
                    amountOfPassengers, driverSalary, carNeedsService, isVip);
        }
    }

    public Order getOrder(UUID orderId) {

        String address = "http://orderserver:8087/order/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("orderId", orderId);

        HttpEntity<List<Order>> response = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        List<Order> list = response.getBody();
        if (list.isEmpty())
            return null;
        else
            return list.get(0);

    }

    public Driver findAppropriateDriver() {

        String address = "http://driverserver:8086/personnel/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("status", DriverStatus.free).
                queryParam("id", "").
                queryParam("module", MappingModule.ByStatus);

        HttpEntity<List<Driver>> response = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        List<Driver> list = response.getBody();
        if (list == null) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public Car findAppropriateCar(double distance, int amountOfPassengers) {

        String address = "http://carserver:8083/cars/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("status", CarStatus.isFree).
                queryParam("id", "").
                queryParam("module", MappingModule.ByStatus);

        HttpEntity<List<Car>> response = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        List<Car> carList = response.getBody();
        if (carList == null)
            return null;
        for (Car car : carList) {
            if (car.getCapacity() >= amountOfPassengers && car.getEnginePower() >= distance * 10)
                return car;
        }
        return null;
    }


    @PostMapping
    public ResponseEntity<Order> create(@RequestParam int amountOfPassengers, @RequestParam double distance,
                                        @RequestParam UUID clientId) {

        String address = "http://orderserver:8087/order/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("amountOfPassengers", amountOfPassengers).
                queryParam("distance", distance).
                queryParam("clientId", clientId);
        HttpEntity<Order> orderResponse = template.exchange(builder.toUriString(), HttpMethod.POST, null, Order.class);
        return ResponseEntity.ok(Objects.requireNonNull(orderResponse.getBody()));
    }

    @PutMapping
    public ResponseEntity<Boolean> process(@RequestParam UUID orderId) {

        Order order = getOrder(orderId);
        if (order == null)
            return ResponseEntity.ok(Boolean.FALSE);
        System.out.println(order);
        Car car = findAppropriateCar(order.getDistance(), order.getAmountOfPassengers());
        Driver driver = findAppropriateDriver();
        order.setCarId(car.getCarID());
        order.setDriverId(driver.getDriverId());

        String address = "http://orderserver:8087/order/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("orderId", order.getOrderID());
        HttpEntity<Order> response = template.exchange(builder.toUriString(), HttpMethod.PUT, null, Order.class);
        order = response.getBody();
        Client client = getOrderClient(Objects.requireNonNull(order).getClientId());
        checkClientsPayAbility(order, order.getDistance(), order.getAmountOfPassengers(), client.isVip());
        updateInformation(order);

        return ResponseEntity.ok(order.getStatus() == OrderStatus.isCompleted);

    }
}



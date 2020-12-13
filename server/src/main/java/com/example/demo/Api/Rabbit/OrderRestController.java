package com.example.demo.Api.Rabbit;

import com.example.demo.Api.Rabbit.carDto.UpdateInfo;
import com.example.demo.Api.Rabbit.orderDto.CreateInfo;
import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.CarInfo.Car;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import com.example.demo.Services.MainClasses.ClientInfo.Client;
import com.example.demo.Services.MainClasses.DriverInfo.Driver;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import com.example.demo.Services.MainClasses.OrderInfo.Order;
import com.example.demo.Services.MainClasses.OrderInfo.OrderStatus;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/order")
public class OrderRestController {

    private final RestTemplate template = new RestTemplate();
    private final RabbitTemplate rabbitTemplate = new RabbitTemplate();


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

    private Object updateCarInformation(UUID carId, double distance) {

        UpdateInfo info = new UpdateInfo(carId, distance);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive("exchange", RabbitConfiguration.Car_Key_Update, request);
        assert response != null;
        return ResponseEntity.ok(response);
    }

    private Object updateDriverInformation(UUID driverId, double distance) {

        com.example.demo.Api.Rabbit.driverDto.UpdateInfo info =
                new com.example.demo.Api.Rabbit.driverDto.UpdateInfo(driverId, distance);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive("exchange", RabbitConfiguration.Driver_Key_Update, request);
        assert response != null;
        return ResponseEntity.ok(response);
    }

    private Object updateCashier(double distance, double carFuelConsumption,
                                 int amountOfPassengers, double driverSalary,
                                 boolean carNeedsService, boolean isVip) {

        com.example.demo.Api.Rabbit.cashierDto.UpdateInfo info =
                new com.example.demo.Api.Rabbit.cashierDto.UpdateInfo(distance, carFuelConsumption, amountOfPassengers, driverSalary, carNeedsService, isVip);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive("exchange", RabbitConfiguration.Cashier_Key_Update, request);
        assert response != null;
        return ResponseEntity.ok(response);
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
    public ResponseEntity<Object> create(@RequestParam int amountOfPassengers, @RequestParam double distance,
                                         @RequestParam UUID clientId) {
        CreateInfo info =
                new CreateInfo(amountOfPassengers, distance, clientId);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive("exchange", RabbitConfiguration.Order_Key_Create, request);
        assert response != null;
        return ResponseEntity.ok(response);
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

        Object response = rabbitTemplate.convertSendAndReceive("exchange", RabbitConfiguration.Order_Key_Update, orderId.toString());


        Client client = getOrderClient(order.getClientId());
        checkClientsPayAbility(order, order.getDistance(), order.getAmountOfPassengers(), client.isVip());
        updateInformation(order);

        return ResponseEntity.ok(order.getStatus() == OrderStatus.isCompleted);

    }
}



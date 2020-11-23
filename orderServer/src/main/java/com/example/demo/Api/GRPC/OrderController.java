package com.example.demo.Api.GRPC;

import com.example.demo.Api.Grpc.Order;
import com.example.demo.Services.MainClasses.OrderInfo.Orders;
import com.example.demo.Services.ServicesRealization.OrderFulfillmentService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class OrderController extends OrderServiceGrpc.OrderServiceImplBase {
    private final OrderFulfillmentService service;

    OrderController(OrderFulfillmentService service) {
        this.service = service;
    }

    @Override
    public void create(Order.CreateRequest request,
                       StreamObserver<Order.OrderResponse> responseObserver) {
        Orders order = service.createOrder(request.getAmountOfPassengers(), request.getDistance(),
                UUID.fromString(request.getClientId()));

        OrderCreateResponse(responseObserver, order);
    }

    @Override
    public void complete(Order.CompleteRequest request, StreamObserver<Order.OrderResponse> responseObserver) {
        Orders order = service.processTheOrder(UUID.fromString(request.getId()));

        try {
            OrderCreateResponse(responseObserver, order);
        } catch (Exception e) {

            System.out.println("Error" + e.getMessage());
            responseObserver.onError(Status.INTERNAL.asException());
        }
    }

    @Override
    public void report(Order.ReportRequest request,
                       StreamObserver<Order.OrderResponse> responseObserver) {
        Orders order = service.getOrderById(UUID.fromString(request.getId())).get(0);

        OrderCreateResponse(responseObserver, order);


    }

    private void OrderCreateResponse(StreamObserver<Order.OrderResponse> responseObserver, Orders order) {
        Order.OrderResponse response = Order.OrderResponse.newBuilder().
                setAmountOfPassengers(order.getAmountOfPassengers()).
                setCarId(order.getCarId().toString()).
                setClientId(order.getClientId().toString()).
                setDriverId(order.getDriverId().toString()).
                setOrderId(order.getOrderId().toString()).
                setDistance(order.getDistance()).
                setStatus(order.getStatus().toString()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}

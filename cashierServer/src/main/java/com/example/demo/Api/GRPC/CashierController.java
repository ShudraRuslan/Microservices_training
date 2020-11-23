package com.example.demo.Api.GRPC;


import com.example.demo.Services.MainClasses.CashierInfo.Cashier;
import com.example.demo.Services.ServicesRealization.CashierService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class CashierController extends com.example.demo.api.Grpc.CashierServiceGrpc.CashierServiceImplBase {
    private final CashierService service;

    CashierController(CashierService service) {
        this.service = service;
    }

    @Override
    public void create(com.example.demo.api.Grpc.Cashier.CreateRequest request, StreamObserver<com.example.demo.api.Grpc.Cashier.CashierResponse> responseObserver) {
        Cashier cashier = service.createCashier(request.getName());
        cashierReportResponse(responseObserver, cashier);
    }

    @Override
    public void report(com.example.demo.api.Grpc.Cashier.ReportRequest request,
                       StreamObserver<com.example.demo.api.Grpc.Cashier.CashierResponse> responseObserver) {
        Cashier cashier = service.getById(UUID.fromString(request.getId()));

        com.example.demo.api.Grpc.Cashier.CashierResponse response = com.example.demo.api.Grpc.Cashier.CashierResponse.newBuilder().
                setId(cashier.getId().toString()).
                setName(cashier.getName()).
                setIsOpen(cashier.isOpen()).
                setFuelCash(cashier.getFuelCash()).
                setBalance(cashier.getBalance()).
                setBookingCash(cashier.getBookingCash()).
                setDriverSalaryCash(cashier.getDriverSalaryCash()).
                setFuelCash(cashier.getFuelCash()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(com.example.demo.api.Grpc.Cashier.UpdateRequest request,
                       StreamObserver<com.example.demo.api.Grpc.Cashier.CashierResponse> responseObserver) {

        Cashier cashier = service.updateCashier(request.getDistance(), request.getCarFuelConsumption(),
                request.getAmountOfPassengers(), request.getDriverSalary(), request.getCarNeedsService(),
                request.getIsVip());

        cashierReportResponse(responseObserver, cashier);
    }

    private void cashierReportResponse(StreamObserver<com.example.demo.api.Grpc.Cashier.CashierResponse> responseObserver,
                                       com.example.demo.Services.MainClasses.CashierInfo.Cashier cashier) {

        com.example.demo.api.Grpc.Cashier.CashierResponse response = com.example.demo.api.Grpc.Cashier.CashierResponse.newBuilder().
                setId(cashier.getId().toString()).
                setName(cashier.getName()).
                setIsOpen(cashier.isOpen()).
                setFuelCash(cashier.getFuelCash()).
                setBalance(cashier.getBalance()).
                setBookingCash(cashier.getBookingCash()).
                setDriverSalaryCash(cashier.getDriverSalaryCash()).
                setFuelCash(cashier.getFuelCash()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void currentCash(com.example.demo.api.Grpc.Cashier.CurrentCashRequest request,
                            StreamObserver<com.example.demo.api.Grpc.Cashier.CurrentCashResponse> responseObserver) {
        double currentCash = service.getCurrentBookingCash(request.getDistance(),
                request.getAmountOfPassengers(), request.getIsVip());


        com.example.demo.api.Grpc.Cashier.CurrentCashResponse response = com.example.demo.api.Grpc.Cashier.CurrentCashResponse.newBuilder().setCurrentCash(currentCash).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

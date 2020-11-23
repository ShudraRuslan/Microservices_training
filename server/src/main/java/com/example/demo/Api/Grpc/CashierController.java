package com.example.demo.Api.Grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class CashierController extends CashierServiceGrpc.CashierServiceImplBase {

    private final String address = "http://cashierserver";
    private final int port = 9084;

    @Override
    public void create(Cashier.CreateRequest request, StreamObserver<Cashier.CashierResponse> responseObserver) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

        Cashier.CashierResponse response = stub.create(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void report(Cashier.ReportRequest request, StreamObserver<Cashier.CashierResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

        Cashier.CashierResponse response = stub.report(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(Cashier.UpdateRequest request,
                       StreamObserver<Cashier.CashierResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

        Cashier.CashierResponse response = stub.update(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }


    @Override
    public void currentCash(Cashier.CurrentCashRequest request,
                            StreamObserver<Cashier.CurrentCashResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

        Cashier.CurrentCashResponse response = stub.currentCash(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

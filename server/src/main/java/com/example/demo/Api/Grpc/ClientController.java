package com.example.demo.Api.Grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class ClientController extends ClientsControllerGrpc.ClientsControllerImplBase {

    private final String address = "http://clientserver";
    private final int port = 9085;

    @Override
    public void create(Clients.CreateRequest request, StreamObserver<Clients.ClientResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        ClientsControllerGrpc.ClientsControllerBlockingStub stub = ClientsControllerGrpc.newBlockingStub(channel);

        Clients.ClientResponse response = stub.create(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void report(Clients.ReportRequest request, StreamObserver<Clients.ClientListResponse> responseObserver) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        ClientsControllerGrpc.ClientsControllerBlockingStub stub = ClientsControllerGrpc.newBlockingStub(channel);

        Clients.ClientListResponse response = stub.report(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

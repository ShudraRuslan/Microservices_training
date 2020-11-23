package com.example.demo.Api.GRPC;

import com.example.demo.Services.MainClasses.ClientInfo.Client;
import com.example.demo.Services.ServicesRealization.ClientService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class ClientController extends ClientsControllerGrpc.ClientsControllerImplBase {
    private final ClientService service;

    ClientController(ClientService service) {
        this.service = service;
    }

    @Override
    public void create(Clients.CreateRequest request, StreamObserver<Clients.ClientResponse> responseObserver) {
        Client client = service.createClient(request.getName(), request.getCash(), request.getIsVip());

        Clients.ClientResponse response = Clients.ClientResponse.newBuilder().
                setCash(client.getCash()).
                setName(client.getName()).
                setIsVip(client.isVip()).
                build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void report(Clients.ReportRequest request, StreamObserver<Clients.ClientListResponse> responseObserver) {
        List<Client> clients = service.clientReport();
        List<Clients.ClientResponse> clientResponse = new ArrayList<>();
        for (Client client : clients) {
            String clientId = client.getClientId().toString();
            Clients.ClientResponse response = Clients.ClientResponse.newBuilder().
                    setName(client.getName()).
                    setCash(client.getCash()).
                    setIsVip((client.isVip())).
                    build();
            clientResponse.add(response);
        }

        Clients.ClientListResponse listResponse = Clients.ClientListResponse.
                newBuilder().addAllClients(clientResponse).build();
        responseObserver.onNext(listResponse);
        responseObserver.onCompleted();
    }
}

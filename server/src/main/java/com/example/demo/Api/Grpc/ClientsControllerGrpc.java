package com.example.demo.Api.Grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: Clients.proto")
public final class ClientsControllerGrpc {

    public static final String SERVICE_NAME = "ClientsController";
    private static final int METHODID_CREATE = 0;
    private static final int METHODID_REPORT = 1;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Clients.CreateRequest,
            com.example.demo.Api.Grpc.Clients.ClientResponse> getCreateMethod;
    private static volatile io.grpc.MethodDescriptor<Clients.ReportRequest,
            Clients.ClientListResponse> getReportMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private ClientsControllerGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "create",
            requestType = Clients.CreateRequest.class,
            responseType = Clients.ClientResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Clients.CreateRequest,
            Clients.ClientResponse> getCreateMethod() {
        io.grpc.MethodDescriptor<Clients.CreateRequest, Clients.ClientResponse> getCreateMethod;
        if ((getCreateMethod = ClientsControllerGrpc.getCreateMethod) == null) {
            synchronized (ClientsControllerGrpc.class) {
                if ((getCreateMethod = ClientsControllerGrpc.getCreateMethod) == null) {
                    ClientsControllerGrpc.getCreateMethod = getCreateMethod =
                            io.grpc.MethodDescriptor.<Clients.CreateRequest, Clients.ClientResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "ClientsController", "create"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Clients.CreateRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Clients.ClientResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new ClientsControllerMethodDescriptorSupplier("create"))
                                    .build();
                }
            }
        }
        return getCreateMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "report",
            requestType = Clients.ReportRequest.class,
            responseType = Clients.ClientListResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Clients.ReportRequest,
            Clients.ClientListResponse> getReportMethod() {
        io.grpc.MethodDescriptor<Clients.ReportRequest, Clients.ClientListResponse> getReportMethod;
        if ((getReportMethod = ClientsControllerGrpc.getReportMethod) == null) {
            synchronized (ClientsControllerGrpc.class) {
                if ((getReportMethod = ClientsControllerGrpc.getReportMethod) == null) {
                    ClientsControllerGrpc.getReportMethod = getReportMethod =
                            io.grpc.MethodDescriptor.<Clients.ReportRequest, Clients.ClientListResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "ClientsController", "report"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Clients.ReportRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Clients.ClientListResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new ClientsControllerMethodDescriptorSupplier("report"))
                                    .build();
                }
            }
        }
        return getReportMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static ClientsControllerStub newStub(io.grpc.Channel channel) {
        return new ClientsControllerStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static ClientsControllerBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new ClientsControllerBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static ClientsControllerFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new ClientsControllerFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (ClientsControllerGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new ClientsControllerFileDescriptorSupplier())
                            .addMethod(getCreateMethod())
                            .addMethod(getReportMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     *
     */
    public static abstract class ClientsControllerImplBase implements io.grpc.BindableService {

        /**
         *
         */
        public void create(Clients.CreateRequest request,
                           io.grpc.stub.StreamObserver<Clients.ClientResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
        }

        /**
         *
         */
        public void report(Clients.ReportRequest request,
                           io.grpc.stub.StreamObserver<Clients.ClientListResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getReportMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getCreateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Clients.CreateRequest,
                                            Clients.ClientResponse>(
                                            this, METHODID_CREATE)))
                    .addMethod(
                            getReportMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Clients.ReportRequest,
                                            Clients.ClientListResponse>(
                                            this, METHODID_REPORT)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class ClientsControllerStub extends io.grpc.stub.AbstractStub<ClientsControllerStub> {
        private ClientsControllerStub(io.grpc.Channel channel) {
            super(channel);
        }

        private ClientsControllerStub(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ClientsControllerStub build(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            return new ClientsControllerStub(channel, callOptions);
        }

        /**
         *
         */
        public void create(Clients.CreateRequest request,
                           io.grpc.stub.StreamObserver<Clients.ClientResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void report(Clients.ReportRequest request,
                           io.grpc.stub.StreamObserver<Clients.ClientListResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getReportMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     *
     */
    public static final class ClientsControllerBlockingStub extends io.grpc.stub.AbstractStub<ClientsControllerBlockingStub> {
        private ClientsControllerBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private ClientsControllerBlockingStub(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ClientsControllerBlockingStub build(io.grpc.Channel channel,
                                                      io.grpc.CallOptions callOptions) {
            return new ClientsControllerBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public Clients.ClientResponse create(Clients.CreateRequest request) {
            return blockingUnaryCall(
                    getChannel(), getCreateMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public Clients.ClientListResponse report(Clients.ReportRequest request) {
            return blockingUnaryCall(
                    getChannel(), getReportMethod(), getCallOptions(), request);
        }
    }

    /**
     *
     */
    public static final class ClientsControllerFutureStub extends io.grpc.stub.AbstractStub<ClientsControllerFutureStub> {
        private ClientsControllerFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private ClientsControllerFutureStub(io.grpc.Channel channel,
                                            io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ClientsControllerFutureStub build(io.grpc.Channel channel,
                                                    io.grpc.CallOptions callOptions) {
            return new ClientsControllerFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Clients.ClientResponse> create(
                Clients.CreateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getCreateMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Clients.ClientListResponse> report(
                Clients.ReportRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getReportMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final ClientsControllerImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(ClientsControllerImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE:
                    serviceImpl.create((Clients.CreateRequest) request,
                            (io.grpc.stub.StreamObserver<Clients.ClientResponse>) responseObserver);
                    break;
                case METHODID_REPORT:
                    serviceImpl.report((Clients.ReportRequest) request,
                            (io.grpc.stub.StreamObserver<Clients.ClientListResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class ClientsControllerBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        ClientsControllerBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Clients.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ClientsController");
        }
    }

    private static final class ClientsControllerFileDescriptorSupplier
            extends ClientsControllerBaseDescriptorSupplier {
        ClientsControllerFileDescriptorSupplier() {
        }
    }

    private static final class ClientsControllerMethodDescriptorSupplier
            extends ClientsControllerBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        ClientsControllerMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}

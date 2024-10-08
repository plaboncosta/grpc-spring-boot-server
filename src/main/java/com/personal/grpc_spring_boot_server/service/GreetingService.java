package com.personal.grpc_spring_boot_server.service;

import greeting.Greeting;
import greeting.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(Greeting.GreetingRequest request, StreamObserver<Greeting.GreetingResponse> responseObserver) {
        String name = request.getName();
        String greeting = String.format("Hello, %s!", name);
        Greeting.GreetingResponse response = Greeting.GreetingResponse.newBuilder()
                .setName(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

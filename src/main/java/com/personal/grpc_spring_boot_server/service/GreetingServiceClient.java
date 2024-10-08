package com.personal.grpc_spring_boot_server.service;

import com.personal.grpc_spring_boot_server.configuration.GrpcClientConfig;
import greeting.Greeting;
import greeting.GreetingServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceClient {

    private final GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub;

    public GreetingServiceClient(GrpcClientConfig grpcClientConfig) {
        blockingStub = GreetingServiceGrpc.newBlockingStub(grpcClientConfig.managedChannel());
    }

    public String greeting(String name) {
        Greeting.GreetingRequest request = Greeting.GreetingRequest.newBuilder()
                .setName(name)
                .build();

        Greeting.GreetingResponse response = blockingStub.greeting(request);
        return response.getName();
    }
}

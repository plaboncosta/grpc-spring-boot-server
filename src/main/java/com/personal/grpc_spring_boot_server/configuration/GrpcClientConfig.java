package com.personal.grpc_spring_boot_server.configuration;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Value("${grpc.client.remoteServer.address}")
    private String remoteServerAddress;

    @Value("${grpc.client.remoteServer.port}")
    private int remoteServerPort;

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder
                .forAddress(remoteServerAddress, remoteServerPort)
                .usePlaintext()
                .build();
    }

}

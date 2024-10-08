package com.personal.grpc_spring_boot_server.controller;

import com.personal.grpc_spring_boot_server.service.GreetingServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingServiceClient greetingServiceClient;

    GreetingController(GreetingServiceClient greetingServiceClient) {
        this.greetingServiceClient = greetingServiceClient;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name) {
        return greetingServiceClient.greeting(name);
    }

}

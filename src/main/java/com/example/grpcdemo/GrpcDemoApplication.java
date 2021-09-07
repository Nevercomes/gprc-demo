package com.example.grpcdemo;

import com.example.grpcdemo.service.HelloWorldService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcDemoApplication.class, args);
        // Run the grpc server
        Server server = ServerBuilder
                .forPort(9000)
                .addService(new HelloWorldService()).build();

        try {
            server.start();
            server.awaitTermination(); // block server
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

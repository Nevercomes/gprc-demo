package com.example.grpcdemo;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component("grpcLauncher")
@Slf4j
public class GrpcLauncher {

    private Server server;

    @Value("${grpc.server.port}")
    private Integer port;

    public void start(Map<String, Object> serviceBeanMap) {
        try {
            ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
            for (Object bean : serviceBeanMap.values()) {
                serverBuilder.addService((BindableService) bean);
                log.info("gRPC Service={} is registered in Spring Context.", bean.getClass().getSimpleName());
            }
            server = serverBuilder.build().start();
            log.info("gRPC server is started at port={}.", port);
            server.awaitTermination();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (server != null) {
                    server.shutdown();
                }
            }));
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

}

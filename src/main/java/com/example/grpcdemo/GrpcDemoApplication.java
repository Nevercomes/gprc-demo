package com.example.grpcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class GrpcDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext c = SpringApplication.run(GrpcDemoApplication.class, args);
        Map<String, Object> grpcServiceBeanMap = c.getBeansWithAnnotation(GrpcService.class);
        GrpcLauncher grpcLauncher = c.getBean("grpcLauncher", GrpcLauncher.class);
        grpcLauncher.start(grpcServiceBeanMap);
        System.out.println("gRPC Server started successfully.");
        System.out.println("            //   ) )  //   ) ) //   ) )         //   ) )                                          \n" +
                "   ___     //___/ /  //___/ / //               ((         ___      __              ___      __    \n" +
                " //   ) ) / ___ (   / ____ / //         ____     \\\\     //___) ) //  ) ) ||  / / //___) ) //  ) ) \n" +
                "((___/ / //   | |  //       //                     ) ) //       //       || / / //       //       \n" +
                " //__   //    | | //       ((____/ /        ((___ / / ((____   //        ||/ / ((____   //        \n");
    }

}

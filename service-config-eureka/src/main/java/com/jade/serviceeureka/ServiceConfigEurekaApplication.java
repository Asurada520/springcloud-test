package com.jade.serviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceConfigEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigEurekaApplication.class, args);
    }

}

package com.jade.serviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceEurekaApplication03 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceEurekaApplication03.class, args);
    }

}

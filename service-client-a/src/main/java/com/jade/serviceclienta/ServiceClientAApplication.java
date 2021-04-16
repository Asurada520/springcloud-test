package com.jade.serviceclienta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceClientAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceClientAApplication.class, args);
    }

}

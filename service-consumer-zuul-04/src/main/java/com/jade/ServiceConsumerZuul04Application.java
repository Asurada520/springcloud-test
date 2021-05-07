package com.jade;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ServiceConsumerZuul04Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerZuul04Application.class, args);
    }

}

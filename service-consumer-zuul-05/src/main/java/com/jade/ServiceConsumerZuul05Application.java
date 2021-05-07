package com.jade;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ServiceConsumerZuul05Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerZuul05Application.class, args);
    }

}

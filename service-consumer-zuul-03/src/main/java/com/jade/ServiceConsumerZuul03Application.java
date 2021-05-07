package com.jade;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ServiceConsumerZuul03Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerZuul03Application.class, args);
    }

}

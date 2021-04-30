package com.jade;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ServiceConsumerZuul01Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerZuul01Application.class, args);
    }

}

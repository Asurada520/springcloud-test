package com.jade;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ServiceConsumerFallbackAlarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerFallbackAlarmApplication.class, args);
    }

}

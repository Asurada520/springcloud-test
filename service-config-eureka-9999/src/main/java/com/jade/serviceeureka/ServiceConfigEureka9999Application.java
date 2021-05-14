package com.jade.serviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ServiceConfigEureka9999Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigEureka9999Application.class, args);
    }

}

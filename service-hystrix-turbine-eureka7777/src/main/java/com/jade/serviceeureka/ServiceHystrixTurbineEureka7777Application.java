package com.jade.serviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

//@SpringBootApplication
//@EnableEurekaServer

@EnableHystrixDashboard
@EnableTurbine

@SpringCloudApplication
public class ServiceHystrixTurbineEureka7777Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHystrixTurbineEureka7777Application.class, args);
    }

}

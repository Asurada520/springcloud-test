package com.jade.serviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy // start zuul proxy pattern
@SpringCloudApplication
public class ServiceZuulEureka9000Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulEureka9000Application.class, args);
    }

}

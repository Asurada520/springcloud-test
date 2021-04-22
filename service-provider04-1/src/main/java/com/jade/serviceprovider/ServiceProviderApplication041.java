package com.jade.serviceprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.jade.serviceprovider.dao")
public class ServiceProviderApplication041 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication041.class, args);
    }

}

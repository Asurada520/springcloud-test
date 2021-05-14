package com.jade.serviceprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.jade.serviceprovider.dao")
@EnableDiscoveryClient
public class ServiceViaSleuthProviderApplication02 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceViaSleuthProviderApplication02.class, args);
    }

}

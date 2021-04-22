package com.jade.serviceprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jade.serviceprovider.dao")
public class ServiceProviderApplication042 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication042.class, args);
    }

}

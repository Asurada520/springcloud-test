package com.jade.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableCircuitBreaker
//@EnableHystrixDashboard

@EnableFeignClients // 开启Feign客户端，指定service接口所在包
@SpringCloudApplication

public class ServiceTurbineClientConsumerApplication054 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTurbineClientConsumerApplication054.class, args);
    }
}

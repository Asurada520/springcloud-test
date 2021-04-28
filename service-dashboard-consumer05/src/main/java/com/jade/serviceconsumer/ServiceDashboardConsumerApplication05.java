package com.jade.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableCircuitBreaker
@EnableFeignClients // 开启Feign客户端，指定service接口所在包
@SpringCloudApplication
@EnableHystrixDashboard

public class ServiceDashboardConsumerApplication05 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDashboardConsumerApplication05.class, args);
    }
}

package com.jade.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableCircuitBreaker
@EnableFeignClients // 开启Feign客户端，指定service接口所在包
@SpringCloudApplication

public class ServiceConsumerApplication04 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication04.class, args);
    }
}

package com.jade.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // 开启Feign客户端，指定service接口所在包

public class ServiceConsumerApplication03 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication03.class, args);
    }
}

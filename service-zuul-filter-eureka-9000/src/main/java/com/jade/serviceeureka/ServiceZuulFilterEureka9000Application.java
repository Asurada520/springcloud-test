package com.jade.serviceeureka;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy // start zuul proxy pattern
@SpringCloudApplication
public class ServiceZuulFilterEureka9000Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulFilterEureka9000Application.class, args);
    }

    // 设置zuul 对consumer 的 负载均衡策略 为 “随机策略”
    @Bean
    public IRule loadBalanceRule(){
        return new RandomRule();
    }

}

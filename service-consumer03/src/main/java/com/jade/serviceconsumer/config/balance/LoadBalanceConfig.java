package com.jade.serviceconsumer.config.balance;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@RibbonClient(name = "service-provider02", configuration = LoadBalanceConfig.class)
public class LoadBalanceConfig {

//    修改负责均衡策略为：随机
    @Bean
    public IRule loadBalanceRule(){
//        return new RandomRule();
//        return new RoundRobinRule();
//        RoundRobinRule roundRobinRule = new RoundRobinRule();

        List<Integer> portsList = new ArrayList<>();
        portsList.add(8892);
        System.out.println("portsList:" + portsList);
        return new CustomRule(portsList);

    }


}

package com.jade.serviceclientb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVICE-JADE-A")
public interface ServiceAFeignClient {

    @RequestMapping("/a/t1")
    public String getInfo2();

}

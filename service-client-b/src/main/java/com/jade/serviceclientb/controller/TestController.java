package com.jade.serviceclientb.controller;

import com.jade.serviceclientb.client.ServiceAFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/b")
@RestController
public class TestController {

    @Autowired
    private ServiceAFeignClient serviceAFeignClient;

    @RequestMapping("/t1")
    public Object getInfo(){
        Object info = serviceAFeignClient.getInfo2();
        String result = "this is a result that b from a ： " + info;
        return result;
    }
}

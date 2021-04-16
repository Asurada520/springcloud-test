package com.jade.serviceclienta.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

@RestController
@RequestMapping("/a")
public class TestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/t1")
    public String getInfo(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "hello world! 端口：" + port ;
    }

}

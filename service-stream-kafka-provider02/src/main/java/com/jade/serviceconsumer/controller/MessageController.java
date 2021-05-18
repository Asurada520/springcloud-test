package com.jade.serviceconsumer.controller;

import com.jade.serviceconsumer.config.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/msg/")
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @RequestMapping("send")
    public Object sendMsg(@RequestParam("message") String message){
//        生产者 发送消息
        boolean sendFlag = producer.sendMessage(message);
        Map<String,Object> result = new HashMap<>();
        result.put("code",200);
        result.put("data",message);
        result.put("flag",sendFlag);
        return result;
    }

}

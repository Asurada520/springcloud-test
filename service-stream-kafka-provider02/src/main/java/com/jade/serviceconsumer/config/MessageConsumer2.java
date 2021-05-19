package com.jade.serviceconsumer.config;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

//@Component
//@EnableBinding(Sink.class)
public class MessageConsumer2 {
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void printMessage(Object message){
        System.out.println(message);
    }
}

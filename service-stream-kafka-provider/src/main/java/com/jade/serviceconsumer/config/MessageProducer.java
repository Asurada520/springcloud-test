package com.jade.serviceconsumer.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
//spring cloud source 类
//将MQ与生产者类通过消息管道进行绑定
@EnableBinding(Source.class)
public class MessageProducer {

//    使用byName注入消息管道，系统中还定义了名称为nullChannel errorChannel 的两个类型的通道
    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel channel;

    public boolean sendMessage(String msg){
        Message<String> message = MessageBuilder.withPayload(msg).build();
        boolean sendFlag = channel.send(message);
        return sendFlag;
    }

}

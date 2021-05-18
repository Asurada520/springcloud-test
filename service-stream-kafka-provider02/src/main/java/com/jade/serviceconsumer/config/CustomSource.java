package com.jade.serviceconsumer.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义管道
 */
public interface CustomSource {

    String CHANNEL_NAME = "test";

    @Output(CustomSource.CHANNEL_NAME)
    MessageChannel output();

}

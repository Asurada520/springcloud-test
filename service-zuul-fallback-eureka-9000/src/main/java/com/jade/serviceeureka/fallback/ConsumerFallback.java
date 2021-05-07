package com.jade.serviceeureka.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


@Component
public class ConsumerFallback implements FallbackProvider {

    //    指定服务降级的微服务名称
    @Override
    public String getRoute() {

//        仅对指定的微服务进行降级
//        return "service-consumer-8080";

//        对服务所有的微服务名称
        return "*";
    }

    //
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        ClientHttpResponse client = new ClientHttpResponse() {

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }

            @Override
            public InputStream getBody() throws IOException {
                String msg = "fallback: " + route;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(msg.getBytes());
                return byteArrayInputStream;
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {

                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE.value();
            }

            @Override
            public String getStatusText() throws IOException {

                return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };


        return client;
    }
}

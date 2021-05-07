package com.jade.controller;

import com.jade.bean.Depart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;
    // 直连提供者
    // private static final String SERVICE_PROVIDER = "http://localhost:8081";
    // 要使用微服务名称来从eureka server查找提供者
    private static final String SERVICE_PROVIDER = "http://service-provider02";

    @Value("${server.port}")
    private String port;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ForkJoinPool pool = new ForkJoinPool(5);

    @PostMapping("/save")
    public boolean saveHandler(@RequestBody Depart depart) {

        String url = SERVICE_PROVIDER + "/provider/depart/save";
        return restTemplate.postForObject(url, depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandler(@PathVariable("id") int id) {
        String url = SERVICE_PROVIDER + "/provider/depart/del/" + id;
        restTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandler(@RequestBody Depart depart) {
        String url = SERVICE_PROVIDER + "/provider/depart/update";
        restTemplate.put(url, depart);
    }

    @HystrixCommand(fallbackMethod = "getHystrixHandler")
    @GetMapping("/get/{id}")
    public Depart getByIdHandler(@PathVariable("id") int id, HttpServletRequest request) {
        String url = SERVICE_PROVIDER + "/provider/depart/get/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }

    // 定义服务降级方法，即响应给客户端的备选方案
    public Depart getHystrixHandler(@PathVariable("id") int id, HttpServletRequest request) {

        System.out.println("token = " + request.getHeader("token"));
        System.out.println("Set-Cookie = " + request.getHeader("Set-Cookie"));

        String remoteAddr = request.getRemoteAddr();
        String key = remoteAddr + "_getHystrixHandler";

        alarm(key);

        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart, port:" + port);
        return depart;
    }

    private void alarm(String key) {
        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps(key);
        String value = ops.get();

        if (value == null) {
            synchronized (this) {
                value = ops.get();
                if (value == null) {
                    // 发送短信
                    sendFallbackMsg(key);
                    value = "已发生服务降级";
                    ops.set(value, 10, TimeUnit.SECONDS);
                }
            }
        }

    }

    private void sendFallbackMsg(String key) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("发生服务异常报警短信：" + key);
            }
        });
    }

    @HystrixCommand(fallbackMethod = "listHandlerHystrix")
    @GetMapping("/list")
    public List<Depart> listHandler() {
        String url = SERVICE_PROVIDER + "/provider/depart/list";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Depart> listHandlerHystrix() {
        List<Depart> resList = new ArrayList<>();
        Depart depart = new Depart();
        depart.setName("no this depart list, port: " + port);
        resList.add(depart);
        return resList;
    }

}

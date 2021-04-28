package com.jade.serviceconsumer.controller;

import com.jade.serviceconsumer.model.DepartEntity;
import com.jade.serviceconsumer.service.DepartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/depart/")
public class DepartController {

    @Autowired
    private DepartService departService;

//    private final static String SERVICE_PROVIDER = "http://localhost:8090";
    private final static String SERVICE_PROVIDER = "http://service-provider02";

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<DepartEntity> listAllDepartHandle() {
        List<DepartEntity> departEntities = departService.listAllDeparts();
        return departEntities;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public boolean saveHandle(@RequestBody DepartEntity departEntity){
        boolean saveDepart = departService.saveDepart(departEntity);
        return saveDepart;
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
    public boolean delHandle(@PathVariable("id") int id){
        boolean removeDepartById = departService.removeDepartById(id);
        return removeDepartById;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public boolean updateHandle(DepartEntity departEntity){
        boolean modifyDepart = departService.modifyDepart(departEntity);
        return modifyDepart;
    }

    @HystrixCommand(fallbackMethod = "getHystrixHandle"
            /*, commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")*/)
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public DepartEntity getDepartHandle(@PathVariable("id") int id){
        DepartEntity departEntity = departService.getDepartById(id);
        return departEntity;
    }

    public DepartEntity getHystrixHandle(@PathVariable("id") int id){
        DepartEntity departEntity = new DepartEntity();
        departEntity.setId(id);
        departEntity.setName("no this depart, method");
        return departEntity;
    }
}

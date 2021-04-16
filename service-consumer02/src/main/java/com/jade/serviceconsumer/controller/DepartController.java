package com.jade.serviceconsumer.controller;

import com.jade.serviceconsumer.model.DepartEntity;
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
    private RestTemplate restTemplate;

//    private final static String SERVICE_PROVIDER = "http://localhost:8090";
    private final static String SERVICE_PROVIDER = "http://service-provider02";

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<DepartEntity> listAllDepartHandle() {
        String url = SERVICE_PROVIDER + "/provider/depart/list";
        List forObject = restTemplate.getForObject(url, List.class);
        return forObject;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public boolean saveHandle(@RequestBody DepartEntity departEntity){
        String url = SERVICE_PROVIDER + "/provider/depart/save";
        ResponseEntity<Boolean> booleanResponseEntity = restTemplate.postForEntity(url, departEntity, Boolean.class);
        if(booleanResponseEntity != null){
            HttpStatus statusCode = booleanResponseEntity.getStatusCode();
            Boolean body = booleanResponseEntity.getBody();
            return true;
        }
        return false;
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
    public boolean delHandle(@PathVariable("id") int id){
        String url = SERVICE_PROVIDER + "/provider/depart/del/" + id;
        restTemplate.delete(url);
        return true;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public boolean updateHandle(DepartEntity departEntity){
        String url = SERVICE_PROVIDER + "/provider/depart/update";
        restTemplate.put(url,departEntity);
        return true;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public DepartEntity getDepartHandle(@PathVariable("id") int id){
        String url = SERVICE_PROVIDER + "/provider/depart/get/" + id;
        DepartEntity forObject = restTemplate.getForObject(url, DepartEntity.class);
        return forObject;
    }

}

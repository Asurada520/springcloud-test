package com.jade.serviceconsumer.service;

import com.jade.serviceconsumer.model.DepartEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("service-provider02")
@RequestMapping("/provider/depart/")
public interface DepartService {

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<DepartEntity> listAllDeparts();

    @RequestMapping(value = "save",method = RequestMethod.POST)
    boolean saveDepart(@RequestBody DepartEntity departEntity);

    @RequestMapping(value = "del/{id}",method = RequestMethod.DELETE)
    boolean removeDepartById(@PathVariable("id") int id);

    @RequestMapping(value = "update",method = RequestMethod.PUT)
    boolean modifyDepart(@RequestBody DepartEntity departEntity);

    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    DepartEntity getDepartById(@PathVariable("id") int id);

}

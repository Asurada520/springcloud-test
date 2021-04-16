package com.jade.serviceprovider.controller;

import com.jade.serviceprovider.model.DepartEntity;
import com.jade.serviceprovider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/provider/depart/")
@RestController
public class DepartController {

    @Autowired
    private DepartService departService;

    @RequestMapping("list")
    public Object getInfo(){
        List<DepartEntity> list = departService.listAllDeparts();
        return list;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public boolean saveHandle(@RequestBody DepartEntity departEntity){
        boolean saveDepart = departService.saveDepart(departEntity);
        return saveDepart;
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
    public boolean delHandle(@PathVariable("id") int id){
        return departService.removeDepartById(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public boolean updateHandle(@RequestBody DepartEntity departEntity){
        boolean saveDepart = departService.modifyDepart(departEntity);
        return saveDepart;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Object getHandle(@PathVariable("id") int id){
        DepartEntity departById = departService.getDepartById(id);
        return departById;
    }

}

package com.jade.serviceprovider.controller;

import com.jade.serviceprovider.model.DepartEntity;
import com.jade.serviceprovider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.cloudfoundry.reactive.CloudFoundryReactiveHealthEndpointWebExtension;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RequestMapping("/provider/depart/")
@RestController
public class DepartController {

    @Autowired
    private DepartService departService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("list")
    public Object getInfo() {
        List<DepartEntity> list = departService.listAllDeparts();
        return list;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public boolean saveHandle(@RequestBody DepartEntity departEntity) {
        boolean saveDepart = departService.saveDepart(departEntity);
        return saveDepart;
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
    public boolean delHandle(@PathVariable("id") int id) {
        return departService.removeDepartById(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public boolean updateHandle(@RequestBody DepartEntity departEntity) {
        boolean saveDepart = departService.modifyDepart(departEntity);
        return saveDepart;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Object getHandle(@PathVariable("id") int id) {

        try {
            TimeUnit.SECONDS.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DepartEntity departById = departService.getDepartById(id);
        return departById;
    }


    @RequestMapping(value = "discovery", method = RequestMethod.GET)
    public Object discoveryHandle() {
        List<String> clientServices = client.getServices();
        for (String clientName : clientServices) {
            List<ServiceInstance> clientInstances = client.getInstances(clientName);
            for (ServiceInstance instance : clientInstances) {
                Map<String, String> metadata = instance.getMetadata();
                String host = instance.getHost();
                int port = instance.getPort();
                String scheme = instance.getScheme();

                System.out.println("metadata:" + metadata + " host:" + host + " port:" + port + " scheme:" + scheme);
            }
        }
        return clientServices;
    }
}

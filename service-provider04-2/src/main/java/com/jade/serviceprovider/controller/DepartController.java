package com.jade.serviceprovider.controller;

import com.jade.serviceprovider.model.DepartEntity;
import com.jade.serviceprovider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.cloudfoundry.reactive.CloudFoundryReactiveHealthEndpointWebExtension;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/provider/depart/")
@RestController
public class DepartController {

    @Autowired
    private DepartService departService;

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String port;

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
        DepartEntity departById = departService.getDepartById(id);
        departById.setName(departById.getName() + ", port:" + port);
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

package com.jade.serviceconsumer.service;

import com.jade.serviceconsumer.model.DepartEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping("/fallback/consumer/depart")
public class DepartFallback implements DepartService {

    @Override
    public boolean saveDepart(DepartEntity depart) {
        System.out.println("执行DepartFallback - saveDepart()的服务降级方法 - class");
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        System.out.println("执行DepartFallback - removeDepartById()的服务降级方法 - class");
        return false;
    }

    @Override
    public boolean modifyDepart(DepartEntity depart) {
        System.out.println("执行DepartFallback - modifyDepart()的服务降级方法 - class");
        return false;
    }

    @Override
    public DepartEntity getDepartById(int id) {
        System.out.println("执行DepartFallback - getDepartById()的服务降级方法 - class");
        DepartEntity depart = new DepartEntity();
        depart.setId(id);
        depart.setName("执行DepartFallback - getDepartById()的服务降级方法 - class");
        return depart;
    }

    @Override
    public List<DepartEntity> listAllDeparts() {
        System.out.println("执行DepartFallback - listAllDeparts()的服务降级方法 - class");
        return null;
    }
}

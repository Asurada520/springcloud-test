package com.jade.serviceconsumer.service;

import com.jade.serviceconsumer.model.DepartEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartFallbackFactory implements FallbackFactory<DepartService> {
    @Override
    public DepartService create(Throwable throwable) {

        return new DepartService() {
            @Override
            public List<DepartEntity> listAllDeparts() {
                System.out.println("执行 DepartFallbackFactory-listAllDeparts() 的服务降级的处理方法");
                return null;
            }

            @Override
            public boolean saveDepart(DepartEntity departEntity) {
                System.out.println("执行 DepartFallbackFactory-saveDepart() 的服务降级的处理方法");
                return false;
            }

            @Override
            public boolean removeDepartById(int id) {
                System.out.println("执行 DepartFallbackFactory-removeDepartById() 的服务降级的处理方法");
                return false;
            }

            @Override
            public boolean modifyDepart(DepartEntity departEntity) {
                System.out.println("执行 DepartFallbackFactory-modifyDepart() 的服务降级的处理方法");
                return false;
            }

            @Override
            public DepartEntity getDepartById(int id) {
                DepartEntity departEntity = new DepartEntity();
                departEntity.setId(id);
                departEntity.setName("no this depart, factory class");
                System.out.println("执行 DepartFallbackFactory-getDepartById() 的服务降级的处理方法");
                return departEntity;
            }
        };
    }
}

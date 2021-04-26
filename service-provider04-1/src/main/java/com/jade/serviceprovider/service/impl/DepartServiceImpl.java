package com.jade.serviceprovider.service.impl;

import com.jade.serviceprovider.dao.DepartMapper;
import com.jade.serviceprovider.model.DepartEntity;
import com.jade.serviceprovider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartMapper departMapper;

    @Override
    public List<DepartEntity> listAllDeparts() {
        return departMapper.listAllDeparts();
    }

    @Override
    public boolean saveDepart(DepartEntity departEntity) {
        int i = departMapper.saveDepart(departEntity);
        if(i==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        int i = departMapper.removeDepartById(id);
        if(i==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(DepartEntity departEntity) {
        int i = departMapper.modifyDepart(departEntity);
        if(i==1){
            return true;
        }
        return false;
    }

    @Override
    public DepartEntity getDepartById(int id) {

//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        DepartEntity departEntity = departMapper.getDepartById(id);
        return departEntity;
    }
}

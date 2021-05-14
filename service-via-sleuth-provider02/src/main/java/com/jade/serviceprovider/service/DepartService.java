package com.jade.serviceprovider.service;

import com.jade.serviceprovider.model.DepartEntity;

import java.util.List;

public interface DepartService {
    /**
     * 查询 all
     * @return
     */
    public List<DepartEntity> listAllDeparts();

    boolean saveDepart(DepartEntity departEntity);

    boolean removeDepartById(int id);

    boolean modifyDepart(DepartEntity departEntity);

    DepartEntity getDepartById(int id);
}

package com.jade.serviceprovider.dao;

import com.jade.serviceprovider.model.DepartEntity;

import java.util.List;

public interface DepartMapper {


    int saveDepart(DepartEntity departEntity);

    int removeDepartById(int id);

    int modifyDepart(DepartEntity departEntity);

    DepartEntity getDepartById(int id);

    /**
     * 查询 all
     * @return
     */
    public List<DepartEntity> listAllDeparts();



}

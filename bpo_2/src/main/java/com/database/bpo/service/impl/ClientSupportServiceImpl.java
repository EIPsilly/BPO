package com.database.bpo.service.impl;

import com.database.bpo.dao.ClientSupportDao;
import com.database.bpo.pojo.entity.ClientSupport;
import com.database.bpo.service.ClientSupportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClientSupportServiceImpl implements ClientSupportService {
    @Resource
    ClientSupportDao dao;
    @Override
    public String getEquipmentName(Integer equipmentId) {
        String equipmentName = dao.selectByPrimaryKey(equipmentId).getEquipmentName();
        return equipmentName;
    }
}

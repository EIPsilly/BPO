package com.database.bpo.service.impl;

import com.database.bpo.dao.OrdersDao;
import com.database.bpo.dao.OrderwithcontactDao;
import com.database.bpo.pojo.entity.Orders;
import com.database.bpo.pojo.entity.Orderwithcontact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    public static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrdersDao ordersDao;

    @Autowired
    OrderwithcontactDao orderwithcontactDao;

    public boolean Insert(Integer projectId, Integer userEmployeeId,Integer userEmployerId,Float orderAmount){
        Integer rows = ordersDao.insert(new Orders(projectId,userEmployeeId,userEmployerId,new Date(),"未付定金",orderAmount,orderAmount / (float)10.0,orderAmount / (float)10.0));
        logger.debug(rows.toString());
        if (rows == 1) return true;
        return false;
    }

    public List<Orderwithcontact> QueryOrderByEmployerId(Integer userEmployerId){
        List<Orderwithcontact> results = orderwithcontactDao.SelectByuserEmployerId(userEmployerId);
        return results;
    }

    public List<Orderwithcontact> QueryOrderByEmployeeId(Integer userEmployeeId){
        List<Orderwithcontact> results = orderwithcontactDao.SelectByuserEmployeeId(userEmployeeId);
        return results;
    }
}

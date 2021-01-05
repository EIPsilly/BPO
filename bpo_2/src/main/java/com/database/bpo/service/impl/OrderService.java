package com.database.bpo.service.impl;

import com.database.bpo.dao.OrdersDao;
import com.database.bpo.pojo.entity.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    public static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrdersDao ordersDao;

    public boolean Insert(Integer projectId, Integer userEmployeeId,Integer userEmployerId,Float orderAmount){
        Integer rows = ordersDao.insert(new Orders(projectId,userEmployeeId,userEmployerId,new Date(),"未付款",orderAmount,orderAmount / (float)10.0,orderAmount / (float)10.0));
        logger.debug(rows.toString());
        if (rows == 1) return true;
        return false;
    }
}

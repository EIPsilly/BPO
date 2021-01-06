package com.database.bpo.service.impl;

import com.database.bpo.dao.MoneyNotificationDao;
import com.database.bpo.pojo.entity.MoneyNotification;
import com.database.bpo.pojo.entity.Orderwithcontact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MoneyService {

    @Autowired
    MoneyNotificationDao moneyNotificationDao;

    public MoneyNotification CreateNewNotification(Orderwithcontact order,Integer userId,Integer userRoleId){
        MoneyNotification notification = new MoneyNotification();
        Integer orderId = order.getOrderId();
        Float amount = null;
        String moneyDescription = null;
//        如果是发布方支付定金
        if (userRoleId == 1){
            amount = order.getEmployerDeposit();
            moneyDescription = order.getProjectName() + "发布方定金";
        }
//        如果是承包方支付定金
        else{
            amount = order.getEmployeeDeposit();
            moneyDescription = order.getProjectName() + "承包方定金";
        }
        notification.setOrderId(orderId);
        notification.setMoneyTime(new Date());
        notification.setAmount(amount);
        notification.setMoneyType("支付定金");
        notification.setUserId(userId);
        notification.setMoneyDescription(moneyDescription);
        moneyNotificationDao.insert(notification);
        return notification;
    }
}
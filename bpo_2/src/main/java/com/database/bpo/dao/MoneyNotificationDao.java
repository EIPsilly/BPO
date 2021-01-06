package com.database.bpo.dao;

import com.database.bpo.pojo.entity.MoneyNotification;

public interface MoneyNotificationDao {
    int deleteByPrimaryKey(Integer moneyId);

    int insert(MoneyNotification record);

    int insertSelective(MoneyNotification record);

    MoneyNotification selectByPrimaryKey(Integer moneyId);

    int updateByPrimaryKeySelective(MoneyNotification record);

    int updateByPrimaryKey(MoneyNotification record);
}
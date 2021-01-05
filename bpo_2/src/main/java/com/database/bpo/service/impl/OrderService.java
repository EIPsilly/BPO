package com.database.bpo.service.impl;

import com.database.bpo.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrdersDao dao;
}

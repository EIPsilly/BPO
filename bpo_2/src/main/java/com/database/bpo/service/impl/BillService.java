package com.database.bpo.service.impl;

import com.database.bpo.dao.BillDao;
import com.database.bpo.pojo.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillDao billDao;

    public List<Bill> SelectByUserId(Integer UserId){
        List<Bill> bills = billDao.SelectByUserId(UserId);
        return bills;
    }
}

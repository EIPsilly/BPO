package com.database.bpo.service.impl;

import com.database.bpo.dao.UserEmployeeDao;
import com.database.bpo.pojo.entity.UserEmployee;
import com.database.bpo.pojo.entity.UserEmployer;
import com.database.bpo.service.UserEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserEmployeeServiceImpl implements UserEmployeeService {
    @Resource
    UserEmployeeDao dao;

    @Override
    public int addNewEmployee(UserEmployee userEmployee) {
        int success = dao.insert2(userEmployee);
        return 0;
    }
}

package com.database.bpo.service.impl;

import com.database.bpo.dao.UserEmployerDao;
import com.database.bpo.pojo.entity.User;
import com.database.bpo.pojo.entity.UserEmployer;
import com.database.bpo.service.UserEmployerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserEmployerServiceImpl implements UserEmployerService {
    @Resource
    UserEmployerDao dao;
    @Override
    public UserEmployer findEmployer(Integer userEmployerId) {
        UserEmployer userEmployer = dao.selectByPrimaryKey(userEmployerId);
        return userEmployer;
    }
}

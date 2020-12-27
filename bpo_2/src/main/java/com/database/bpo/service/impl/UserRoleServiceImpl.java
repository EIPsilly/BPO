package com.database.bpo.service.impl;

import com.database.bpo.dao.UserRoleDao;
import com.database.bpo.pojo.entity.UserRole;
import com.database.bpo.service.UserRoleService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    UserRoleDao dao;

    @Override
    public boolean addNewUserRole(Integer userId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);

        userRole.setRoleId(1);
        int employer = dao.insert(userRole);
        userRole.setRoleId(2);
        int employee = dao.insert(userRole);
        if(employee != 0 && employer != 0){
            return true;
        }
        return false;
    }

    @Override
    public UserRole findUserRole(Integer userId){
        UserRole userRole = new UserRole();
        Integer RoleId = 1;
        userRole = dao.selectByUserIdAndRoleId(userId,1);
        return userRole;
    }



}

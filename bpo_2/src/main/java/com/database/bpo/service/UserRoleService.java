package com.database.bpo.service;

import com.database.bpo.pojo.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    boolean addNewUserRole(Integer userId);
    UserRole findUserRoleEmployer(Integer userID);
    UserRole findUserRoleEmployee(Integer userID);
    UserRole findProjectAdmin(Integer userId);
}

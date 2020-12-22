package com.database.bpo.dao;

import com.database.bpo.pojo.entity.AdminForProject;

public interface AdminForProjectDao {
    int deleteByPrimaryKey(Integer userProjectAdminId);

    int insert(AdminForProject record);

    int insertSelective(AdminForProject record);

    AdminForProject selectByPrimaryKey(Integer userProjectAdminId);

    int updateByPrimaryKeySelective(AdminForProject record);

    int updateByPrimaryKey(AdminForProject record);
}
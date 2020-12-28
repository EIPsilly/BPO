package com.database.bpo.dao;

import com.database.bpo.pojo.entity.UserEmployer;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserEmployerDao {
    int deleteByPrimaryKey(Integer userEmployerId);

    int insert(UserEmployer record);

    int insert2(UserEmployer record);

    int insertSelective(UserEmployer record);

    UserEmployer selectByPrimaryKey(Integer userEmployerId);

    int updateByPrimaryKeySelective(UserEmployer record);

    int updateByPrimaryKey(UserEmployer record);


}

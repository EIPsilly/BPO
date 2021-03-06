package com.database.bpo.dao;

import com.database.bpo.pojo.entity.ProjectType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectTypeDao {
    int deleteByPrimaryKey(Integer projectTypeId);

    int insert(ProjectType record);

    int insertSelective(ProjectType record);

    ProjectType selectByPrimaryKey(Integer projectTypeId);

    int updateByPrimaryKeySelective(ProjectType record);

    int updateByPrimaryKey(ProjectType record);
}

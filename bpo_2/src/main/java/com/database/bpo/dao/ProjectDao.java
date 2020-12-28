package com.database.bpo.dao;

import com.database.bpo.pojo.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectDao {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectId);

    List<Project> selectPassed();

    List<Project> selectUnexamined();

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

}

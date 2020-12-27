package com.database.bpo.service.impl;

import com.database.bpo.dao.ProjectTypeDao;
import com.database.bpo.service.ProjectTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {
    @Resource
    ProjectTypeDao dao;
    @Override
    public String findProjectTypeName(Integer projectTypeId) {
        String projectTypeName = dao.selectByPrimaryKey(projectTypeId).getProjectTypeName();
        return projectTypeName;
    }
}

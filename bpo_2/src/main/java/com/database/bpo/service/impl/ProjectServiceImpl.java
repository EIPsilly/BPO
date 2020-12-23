package com.database.bpo.service.impl;

import com.database.bpo.dao.ProjectDao;
import com.database.bpo.pojo.entity.Project;
import com.database.bpo.service.ProjectService;

import javax.annotation.Resource;

public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectDao dao;
    @Override
    public boolean addNewProject(Project project) {
        int key = dao.insertSelective(project);

        return false;
    }
}

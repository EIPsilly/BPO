package com.database.bpo.service.impl;

import com.database.bpo.dao.ProjectDao;
import com.database.bpo.pojo.entity.Project;
import com.database.bpo.service.ProjectService;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectDao dao;
    @Override
    public boolean addNewProject(Project project) {
        //获得返回值
        int key = dao.insertSelective(project);
        if(key!=0){
            return true;
        }
        return false;
    }

    @Override
    public List<Project> selectTopProject() {
        List<Project> projectList = new ArrayList<>();
        Project project = new Project();
        projectList = dao.selectAll();
        return projectList;
    }



}

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
    public List<Project> selectPassedProject() {
        List<Project> projectList = new ArrayList<>();
        Project project = new Project();
        projectList = dao.selectPassed();
        return projectList;
    }

    @Override
    public List<Project> selectUnexaminedProject() {
        List<Project> projectList = new ArrayList<>();
        Project project = new Project();
        projectList = dao.selectUnexamined();
        return projectList;
    }

    @Override
    public Project selectProjectByKey(Integer projectId) {
        Project project = dao.selectByPrimaryKey(projectId);

        return project;
    }

    @Override
    public Integer examinePassed(Integer projectId, Integer projectAdminId) {
        int success = dao.updateByProjectIdAndAdmin(projectId,projectAdminId,"已通过");
        return success;
    }

    @Override
    public Integer examineRefused(Integer projectId, Integer projectAdminId) {
        int success = dao.updateByProjectIdAndAdmin(projectId,projectAdminId,"未通过");
        return success;
    }

    @Override
    public List<Project> selectProjectByUserEmployerId(Integer userEmployerId) {
        List<Project> projectList = new ArrayList<>();
        projectList = dao.selectByUserEmployerId(userEmployerId);
        return projectList;
    }


}

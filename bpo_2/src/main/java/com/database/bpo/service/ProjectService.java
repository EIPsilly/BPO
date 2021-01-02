package com.database.bpo.service;

import com.database.bpo.pojo.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public boolean addNewProject(Project project);
    public List<Project> selectPassedProject();
    public List<Project> selectUnexaminedProject();
    public Project selectProjectByKey(Integer projectId);
    public Integer examinePassed(Integer projectId,Integer projectAdminId);
    public Integer examineRefused(Integer projectId,Integer projectAdminId);
    public List<Project> selectProjectByUserEmployerId(Integer userEmployerId);
}

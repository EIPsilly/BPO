package com.database.bpo.service;

import com.database.bpo.pojo.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public boolean addNewProject(Project project);
    public List<Project> selectTopProject();
}

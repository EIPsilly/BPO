package com.database.bpo.service;

import com.database.bpo.pojo.entity.Project;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    public boolean addNewProject(Project project);
}

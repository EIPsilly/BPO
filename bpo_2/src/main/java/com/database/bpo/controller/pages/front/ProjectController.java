package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.Project;
import com.database.bpo.service.ProjectService;
import com.database.bpo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.time.Period;

@Controller
@RequestMapping("/pages/front")
public class ProjectController {
    @Resource
    ProjectService projectService;

    @RequestMapping("/addNewProject")
    public String addNewProject(int projectTypeId,int equipmentId,String projectName,
                                String projectRequirement,String skillsRequirement ,int projectPeriod){

        return null;
    }
}

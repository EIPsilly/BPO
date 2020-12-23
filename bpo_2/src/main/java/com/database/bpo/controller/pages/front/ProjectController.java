package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.Project;
import com.database.bpo.service.ProjectService;
import com.database.bpo.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/pages/front")
public class ProjectController {
    @Resource
    ProjectService projectService;

    @RequestMapping("/addNewProject")
    public String addNewProject(Integer projectTypeId, HttpServletRequest request, String projectName, String projectRequirement,
                                String skillsRequirement , int projectPeriod, String projectBudget, String connectTel, String connectName){
        String[] values = request.getParameterValues("equipmentId");
//        System.out.println(values.toString());
        Integer a = projectTypeId;
        System.out.println("1");
        return null;
    }
}

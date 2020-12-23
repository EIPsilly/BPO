package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.Project;
import com.database.bpo.pojo.entity.User;
import com.database.bpo.service.ProjectService;
import com.database.bpo.service.UserService;

import com.mysql.cj.xdevapi.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/pages/front")
public class ProjectController {
    @Resource
    ProjectService projectService;
    @Resource
    UserService userService;
    @RequestMapping("/addNewProject")
    public String addNewProject(Integer projectTypeId, HttpServletRequest request, String projectName, String projectRequirement,
                                String skillsRequirement , int projectPeriod, String projectBudget, String connectTel, String connectName, Model model){
        //获取适配客户端id
        String[] values = request.getParameterValues("equipmentId");
        //获取用户id
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("User");
        User user = userService.findUser(userName);
        Integer userid = user.getUserId();

        //处理客户端id
        String tmpEquipmentId = "";
        for(int i = 0;i<values.length-1;i++){
            tmpEquipmentId += values[i]+"/";
        }
        tmpEquipmentId += values[values.length-1];

        //处理工期
        String projectPeriodString =Integer.toString(projectPeriod);

        //添加到project
        Project project = new Project();
        project.setProjectTypeId(projectTypeId);
        project.setEquipmentId(tmpEquipmentId);
        project.setProjectName(projectName);
        project.setProjectRequirement(projectRequirement);
        project.setSkillsRequirement(skillsRequirement);
        project.setProjectPeriod(projectPeriodString);
        project.setProjectBudget(projectBudget);
        project.setConnectTel(connectTel);
        project.setConnectName(connectName);
        boolean flag = projectService.addNewProject(project);
        if(flag == true){
            model.addAttribute("successMsg","插入成功");
            return "pages/front/bpo_main/PublishProject";
        }
        return null;
    }
}

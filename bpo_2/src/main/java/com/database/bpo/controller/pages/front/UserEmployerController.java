package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.UserEmployer;
import com.database.bpo.service.*;
import com.mysql.cj.protocol.a.NativeConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/pages/back")
public class UserEmployerController {
    @Resource
    ProjectService projectService;
    @Resource
    UserService userService;
    @Resource
    UserRoleService userRoleService;
    @Resource
    UserEmployerService userEmployerService;
    @Resource
    ClientSupportService clientSupportService;
    @Resource
    ProjectTypeService projectTypeService;

    @RequestMapping("/findEmployerInfo")
    @ResponseBody
    public UserEmployer findEmployerInfo(Integer projectId){
        //通过projectId查询employerId
        Integer employerId = projectService.selectProjectByKey(projectId).getUserEmployerId();
        //通过employerId查询发包方信息
        UserEmployer userEmployer = userEmployerService.findEmployer(employerId);
        return userEmployer;
    }
}

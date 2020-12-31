package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.BiddingScheme;
import com.database.bpo.pojo.entity.Project;
import com.database.bpo.pojo.entity.User;
import com.database.bpo.pojo.entity.UserRole;
import com.database.bpo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class BiddingController {
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
    @Resource
    BiddingSchemeService biddingSchemeService;
    @RequestMapping("/addNewBidding")
    public String addNewBidding(HttpSession session,String projectId,String projectPeriod,String projectAmout,String projectSuperiority,
        String biddingExample,String userEmployeeName,String userEmployeeTel){
        BiddingScheme biddingScheme = new BiddingScheme();
        //获取接包方信息
        String userName =(String) session.getAttribute("User");
        User user = userService.findUser(userName);
        Integer userId = user.getUserId();
        UserRole Employee = userRoleService.findUserRoleEmployee(userId);
        Integer userEmployeeId = Employee.getUserRoleId();
        biddingScheme.setUserEmployeeId(userEmployeeId);
        //获取发包方信息
        Project project = projectService.selectProjectByKey(Integer.valueOf(projectId));
        Integer userEmployerId = project.getUserEmployerId();
        biddingScheme.setUserEmployerId(userEmployerId);
        //添加表信息，以下为直接读取
        biddingScheme.setProjectId(Integer.valueOf(projectId));
        biddingScheme.setProjectPeriod(projectPeriod);
        biddingScheme.setProjectAmout(projectAmout);
        biddingScheme.setProjectSuperiority(projectSuperiority);
        biddingScheme.setBiddingExample(biddingExample);
        biddingScheme.setUserEmployeeName(userEmployeeName);
        biddingScheme.setUserEmployeeTel(userEmployeeTel);

        boolean success = biddingSchemeService.addNewBidding(biddingScheme);

        return "redirect:/listPage";
    }

}

package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.User;
import com.database.bpo.pojo.entity.UserEmployee;
import com.database.bpo.pojo.entity.UserEmployer;
import com.database.bpo.service.UserEmployeeService;
import com.database.bpo.service.UserEmployerService;
import com.database.bpo.service.UserRoleService;
import com.database.bpo.service.UserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    UserRoleService userRoleService;
    @Resource
    UserEmployerService userEmployerService;
    @Resource
    UserEmployeeService userEmployeeService;

    @RequestMapping("login")
    public String Login(HttpServletRequest request, User user, Model model)
    {
        boolean loginResult = userService.login(user);
        if(loginResult){
            model.addAttribute("successMsg","登陆成功");
            HttpSession session = request.getSession();
            session.setAttribute("User",user.getUserName());
            return "redirect:/listPage";
        }
        else{
            model.addAttribute("errMessage","账号或密码错误，请重新输入");
            return "pages/front/login";
        }
    }

    @RequestMapping("register")
    public String Register(HttpSession session,User user, String rePassword, Model model){
        String regResult = userService.register(user,rePassword);
        if ("注册成功".equals(regResult)){
            //为用户添加身份
            int userId = userService.findUser(user.getUserName()).getUserId();
            boolean flag = userRoleService.addNewUserRole(userId);
            //需要查询出两个身份对应的user_Role_ID
            Integer userEmployerId,userEmployeeId;
            userEmployerId = userRoleService.findUserRoleEmployer(userId).getUserRoleId();
            userEmployeeId = userRoleService.findUserRoleEmployee(userId).getUserRoleId();
            //添加发包方表中信息
            UserEmployer userEmployer = new UserEmployer();
            userEmployer.setUserEmployerId(userEmployerId);
            userEmployer.setUserEmployerName(user.getUserName());
            int addEmployer = userEmployerService.addNewEmployer(userEmployer);
            System.out.println(addEmployer);
            //添加接包方表中信息

            UserEmployee userEmployee = new UserEmployee();
            userEmployee.setUserEmployeeId(userEmployeeId);
            int addEmployee = userEmployeeService.addNewEmployee(userEmployee);
            System.out.println(addEmployee);
            //传递信息
            model.addAttribute("successMsg",regResult);
            session.setAttribute("User",user.getUserName());
            return "redirect:/listPage";
        }
        else {
            model.addAttribute("errMessage",regResult);
            return "pages/front/register";
        }
    }

}

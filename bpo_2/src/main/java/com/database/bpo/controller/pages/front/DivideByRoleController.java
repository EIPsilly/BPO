package com.database.bpo.controller.pages.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class DivideByRoleController {

    @RequestMapping("/Desk")
    public String DivideByRole(HttpSession session){
        Integer role = (Integer) session.getAttribute("userRoleId");
        if (role == 1) {
            Integer userEmployerId = (Integer) session.getAttribute("userEmployerId");
//            return "/pages/front/EmployerQueryOrder?userEmployerId = " + userEmployerId.toString();
            return "pages/front/bpo_employer/EmployerProject";
        }
        else return "pages/front/bpo_employee/EmployeeProject";
    }
}

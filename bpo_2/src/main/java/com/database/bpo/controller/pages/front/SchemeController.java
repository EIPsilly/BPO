package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.Schemewithprojectname;
import com.database.bpo.service.impl.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/pages/front")
public class SchemeController {

    @Autowired
    SchemeService schemeService;

    @RequestMapping("/EmployeeScheme")
    public String SelectByuserEmployeeId(HttpSession session, Model model){
        Integer userEmployeeId = (Integer)session.getAttribute("userEmployeeId");
        List<Schemewithprojectname> results = schemeService.SelectByuserEmployeeId(userEmployeeId);
        model.addAttribute("Schemes",results);
        return "pages/front/bpo_employee/EmployeeScheme";
    }
}

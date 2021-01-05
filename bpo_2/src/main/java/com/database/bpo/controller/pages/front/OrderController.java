package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.Orderwithcontact;
import com.database.bpo.service.ProjectService;
import com.database.bpo.service.impl.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/pages/front")
public class OrderController {

    public static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @Resource
    ProjectService projectService;

    @RequestMapping("/CreateOrder")
    public String CreateOrder(Integer projectId, Integer userEmployeeId,Float orderAmount, HttpSession session){
        Integer userEmployerId = (Integer)session.getAttribute("userEmployerId");
//        logger.debug(projectId.toString());
//        logger.debug(userEmployeeId.toString());
//        logger.debug(userEmployerId.toString());
//        logger.debug(orderAmount.toString());
        orderService.Insert(projectId,userEmployeeId,userEmployerId,orderAmount);
        projectService.UpdateProjectType(projectId,"已出单");
        return "redirect:/EmployerProject";
    }

    @RequestMapping("/EmployerQueryOrder")
    public String QueryOrderByEmployerId(HttpSession session,Model model){
        Integer userEmployerId = (Integer) session.getAttribute("userEmployerId");
        List<Orderwithcontact> results = orderService.QueryOrderByEmployerId(userEmployerId);
        model.addAttribute("EmployerOrders",results);
        return "pages/front/bpo_employer/EmployerOrder";
    }

//    @RequestMapping("/EmployeeQueryOrder")
//    public String QueryOrderByEmployeeId(HttpSession session,Model model){
//        Integer userEmployeeId = (Integer) session.getAttribute("userEmployeeId");
//        List<Orderwithcontact> results = orderService.QueryOrderByEmployeeId(userEmployeeId);
//        model.addAttribute("EmployeeOrders",results);
//        return "pages/front/bpo_employee/EmployeeOrder";
//    }
}

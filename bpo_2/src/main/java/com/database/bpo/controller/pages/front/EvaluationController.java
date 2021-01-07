package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.Orderwithcontact;
import com.database.bpo.pojo.entity.UserRole;
import com.database.bpo.service.UserRoleService;
import com.database.bpo.service.impl.EvaluationService;
import com.database.bpo.service.impl.OrderService;
import com.database.bpo.service.impl.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class EvaluationController {

    @Autowired
    OrderService orderService;

    @Autowired
    EvaluationService evaluationService;

    @RequestMapping("/EvaluationPage")
    public String EvaluationPage(Integer orderId, HttpSession session, Model model){
        Integer userRoleId = (Integer)session.getAttribute("userRoleId");
        Orderwithcontact order = orderService.SelectByOrderId(orderId);
        if (userRoleId == 1) model.addAttribute("userRoleId",order.getUserEmployeeId());
        else model.addAttribute("userRoleId",order.getUserEmployerId());
        model.addAttribute("orderId",order.getOrderId());
        return "/pages/front/Evaluation";
    }

    @RequestMapping("/Evaluate")
    public String evaluate(Integer userRoleId,Integer orderId,String Evaluation,HttpSession session){
        evaluationService.AddEvaluation(userRoleId,orderId,Evaluation);
        Integer role = (Integer)session.getAttribute("userRoleId");
        orderService.EvaluationChangeOrderState(orderId,role);
        if (role == 1) return "redirect:/pages/front/EmployerQueryOrder";
        return "redirect:/pages/front/EmployeeQueryOrder";
    }
}

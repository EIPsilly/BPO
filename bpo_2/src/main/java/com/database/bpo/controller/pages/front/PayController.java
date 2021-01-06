package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.Orderwithcontact;
import com.database.bpo.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class PayController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/Pay")
    public String EmployerPay(Integer orderId, Model model){
        Orderwithcontact order = orderService.SelectByOrderId(orderId);
        model.addAttribute("order",order);
        return "/pages/front/pay";
    }
}

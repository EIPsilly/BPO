package com.database.bpo.controller.pages.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class OrderController {

    @RequestMapping("/CreateOrder")
    public String CreateOrder(Integer projectId, Integer userEmployeeId, HttpSession session){
        Integer userEmployerId = (Integer)session.getAttribute("userEmployerId");
        System.out.println(projectId);
        System.out.println(userEmployeeId);
        System.out.println(userEmployerId);

        return "";
    }
}

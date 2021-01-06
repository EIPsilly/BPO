package com.database.bpo.controller.pages.front;

import com.database.bpo.dao.UserDao;
import com.database.bpo.pojo.entity.MoneyNotification;
import com.database.bpo.pojo.entity.Orderwithcontact;
import com.database.bpo.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Money")
public class MoneyController {

    @Autowired
    OrderService orderService;

    @Autowired
    MoneyService moneyService;

    @Autowired
    BillService billService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CashFlowService cashFlowService;

    @RequestMapping("/UserPayDeposit")
    public String UserPayForOrder(Integer orderId, HttpSession session){
        Integer userRoleId = (Integer)session.getAttribute("userRoleId");
        Integer userId = (Integer)session.getAttribute("userId");
        Orderwithcontact order = orderService.SelectByOrderId(orderId);
//        添加拨款单
        MoneyNotification notification = moneyService.CreateNewNotification(order, userId,userRoleId);
//        用户账单 添加支付定金记录
        billService.AddNewBill(notification);
//        修改用户账户余额
        userService.ChangeMoney(notification);
//        平台流水表 添加定金收款记录
        cashFlowService.AddNewCashFlow(notification);
//        订单修改状态
        orderService.DepositChangeOrderState(order,userRoleId);
        if (userRoleId == 1) return "redirect:/pages/front/EmployerQueryOrder";
        return "redirect:/pages/front/EmployeeQueryOrder";
    }

}

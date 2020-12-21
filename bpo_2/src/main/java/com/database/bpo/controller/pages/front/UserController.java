package com.database.bpo.controller.pages.front;

import com.database.bpo.pojo.entity.User;
import com.database.bpo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/pages/front")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("listPage")
    public String listPage(){
        return "pages/front/bpo_main/bpo_list2";
    }


    @RequestMapping("login")
    public String Login(User user, Model model)
    {
        boolean loginResult = userService.login(user);
        if(loginResult){
            model.addAttribute("successMsg","登陆成功");
            return "pages/front/login1";
        }
        else{
            model.addAttribute("errMessage","账号或密码错误，请重新输入");
            return "pages/front/login";
        }
    }

    @RequestMapping("register")
    public String Register(User user, String rePassword, Model model){
        String regResult = userService.register(user,rePassword);
        if ("注册成功".equals(regResult)){
            model.addAttribute("successMsg",regResult);
            return "pages/front/login1";
        }
        else {
            model.addAttribute("errMessage",regResult);
            return "pages/front/register";
        }
    }
}

package com.database.bpo.controller.pages.front;

import com.database.bpo.dao.UserDao;
import com.database.bpo.pojo.entity.User;
import com.database.bpo.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

@Controller
@RequestMapping("/pages/front")
public class UserController {
    @Resource
    UserService userService;

//    @Autowired
//    public UserServie;

    //登录页面
    @RequestMapping("loginPage")
    public String LoginPage()
    {
        return "pages/front/login";
    }
    //注册页面

    @RequestMapping("regPage")
    public String RegPage(){
        return "pages/front/register";

    }

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
            boolean regResult = userService.register(user,rePassword);
        if(regResult) {
            model.addAttribute("successMsg","恭喜注册成功");
            return "pages/front/login1";
        }
        else {
            model.addAttribute("errMessage","该账号已存在，请更换账户名");
            return "pages/front/register";
        }
    }


}

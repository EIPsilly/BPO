package com.database.bpo.controller.pages.front;

import com.database.bpo.dao.UserDao;
import com.database.bpo.pojo.entity.User;
import com.database.bpo.service.UserService;
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

    @RequestMapping("loginPage")
    String LoginPage()
    {
        return "pages/front/login";
    }
    @RequestMapping("login")
    String Login(User user, Model model)
    {
        boolean loginResult = userService.login(user);
        if(loginResult){
            return "pages/front/login1";
        }
        else{
            model.addAttribute("errMessage","账号或密码错误，请重新输入");
            return "pages/front/login";
        }
    }
}

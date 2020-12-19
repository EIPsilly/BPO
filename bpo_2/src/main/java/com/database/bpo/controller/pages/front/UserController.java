package com.database.bpo.controller.pages.front;

import com.database.bpo.dao.UserDao;
import com.database.bpo.pojo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

@Controller
@RequestMapping("/pages/front")
public class UserController {
    @Resource
    UserDao userDao;

//    @Autowired
//    public UserServie;
    @RequestMapping("loginPage")
    String LoginPage()
    {
//        User user = userDao.selectByPrimaryKey(28);

        return "pages/front/login";
    }
    @RequestMapping("login")
    String Login(String User_Name, Model model)
    {
        if(User_Name.equals("111")){
            model.addAttribute("errMessage","success");
            return "pages/front/login";
        }

        return "pages/front/login";
    }
}

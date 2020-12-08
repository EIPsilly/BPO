package BPO.login.controller;

import BPO.login.mybatis.po.User;
import BPO.login.service.UserService;
import com.alibaba.fastjson.JSON;
import com.mysql.cj.xdevapi.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/User")
public class UserController{

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login.do",produces = {"text/plain;charset=utf-8"})
    @ResponseBody
    public String login(HttpSession session, User user){
        if (userService.login(user)) return "登录成功";
        else return "用户名或密码错误";
    }

    @RequestMapping(value = "/register.do",produces = {"text/plain;charset=utf-8"})
    @ResponseBody
    public String register(HttpSession session, User user, String rePassword){
        return userService.register(user,rePassword);
    }
}
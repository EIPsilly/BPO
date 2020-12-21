package com.database.bpo.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("User");
        if (user == null){
            request.setAttribute("errMessage","没有权限,请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
        } else{
            return true;
        }
        return false;
    }
}

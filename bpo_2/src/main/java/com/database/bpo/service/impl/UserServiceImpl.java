package com.database.bpo.service.impl;

import com.database.bpo.dao.UserDao;
import com.database.bpo.pojo.entity.User;
import com.database.bpo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service //交给springIOC（容器管理），后续自动装配使用
public class UserServiceImpl implements UserService {

    @Resource
    UserDao dao;

    @Override
    public boolean login(User user) {
        User dbUser = dao.selectByUserName(user.getUserName());
        if(dbUser == null){ //数据库中没有该用户
            return false;
        }else{
            if(dbUser.getPassword()==null){ //数据库密码为空
                return false;
            }
            if(dbUser.getPassword().equals(user.getPassword())){ //密码一致
                return true;
            }
        }
        return false;
    }
}

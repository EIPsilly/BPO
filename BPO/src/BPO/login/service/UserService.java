package BPO.login.service;

import BPO.login.dao.UserDao;
import BPO.login.mybatis.po.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserService {

    public static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    public boolean login(User loginUser){
        UserDao dao = (UserDao) ctx.getBean(UserDao.class);
        User user = dao.SelectUserByUser_Name(loginUser.getUser_Name());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) return true;
        return false;
    }

    public String register(User registerUser,String rePassword){
        UserDao dao = (UserDao) ctx.getBean(UserDao.class);
        if (registerUser.getPassword().equals(rePassword)) {
            try{
                int row = dao.InsertIntoUser(registerUser);
            } catch (DuplicateKeyException e){
                return "用户名已存在";
            }
            return "注册成功";
        }
        else return "两次密码不一样";
    }
}

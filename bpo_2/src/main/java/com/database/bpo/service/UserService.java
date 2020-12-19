package com.database.bpo.service;

//import javafx.application.Application;
import com.database.bpo.pojo.entity.User;
import com.sun.glass.ui.Application;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface UserService {

    boolean login(User user);

}

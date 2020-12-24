package com.database.bpo.service;

import com.database.bpo.pojo.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean login(User user);
    String register(User user,String rePassword);
    User findUser(String userName);
}

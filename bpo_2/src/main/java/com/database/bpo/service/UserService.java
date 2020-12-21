package com.database.bpo.service;

import com.database.bpo.pojo.entity.User;

public interface UserService {

    boolean login(User user);
    String register(User user,String rePassword);

}

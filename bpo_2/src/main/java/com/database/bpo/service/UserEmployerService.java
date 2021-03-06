package com.database.bpo.service;

import com.database.bpo.pojo.entity.UserEmployer;
import org.springframework.stereotype.Service;

@Service
public interface UserEmployerService {
    public UserEmployer findEmployer(Integer userEmployerId);
    public int addNewEmployer(UserEmployer userEmployer);
}

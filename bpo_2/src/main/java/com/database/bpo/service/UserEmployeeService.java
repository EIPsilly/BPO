package com.database.bpo.service;

import com.database.bpo.pojo.entity.UserEmployee;
import com.database.bpo.pojo.entity.UserEmployer;
import org.springframework.stereotype.Service;

@Service
public interface UserEmployeeService {
    public int addNewEmployee(UserEmployee userEmployee);
}

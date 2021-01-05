package com.database.bpo.dao;

import com.database.bpo.pojo.entity.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeDao {

    @Select("Select * from Employee where User_Employee_ID=#{userEmployeeId}")
    Employee SelectById(Integer userEmployeeId);

}
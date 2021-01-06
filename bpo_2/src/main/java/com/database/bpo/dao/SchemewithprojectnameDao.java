package com.database.bpo.dao;

import com.database.bpo.pojo.entity.Schemewithprojectname;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SchemewithprojectnameDao {

    @Select("Select * from SchemeWithProjectName Where User_Employee_ID=#{userEmployeeId}")
    List<Schemewithprojectname> SelectByuserEmployeeId(Integer userEmployeeId);
}
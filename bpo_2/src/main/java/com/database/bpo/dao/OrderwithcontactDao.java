package com.database.bpo.dao;

import com.database.bpo.pojo.entity.Orderwithcontact;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderwithcontactDao {

    @Select("Select * From OrderWithContact Where User_Employer_ID = #{userEmployerId}")
    List<Orderwithcontact> SelectByuserEmployerId(Integer userEmployerId);

    @Select("Select * From OrderWithContact Where User_Employee_ID = #{userEmployeeId}")
    List<Orderwithcontact> SelectByuserEmployeeId(Integer userEmployeeId);
}
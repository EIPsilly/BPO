package com.database.bpo.dao;

import com.database.bpo.pojo.entity.Evaluation;
import com.database.bpo.pojo.entity.Evaluationdetails;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EvaluationdetailsDao {

    @Select("Select * from EvaluationDetails Where User_Role_Id = #{UserRoleId}")
    List<Evaluationdetails> SelectByUserRoleId(Integer UserRoleId);
}
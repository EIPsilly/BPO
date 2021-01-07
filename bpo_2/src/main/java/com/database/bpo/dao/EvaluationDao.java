package com.database.bpo.dao;

import com.database.bpo.pojo.entity.Evaluation;
import com.database.bpo.pojo.entity.EvaluationKey;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EvaluationDao {
    int deleteByPrimaryKey(EvaluationKey key);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(EvaluationKey key);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}
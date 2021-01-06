package com.database.bpo.dao;

import com.database.bpo.pojo.entity.CashFlow;
import com.database.bpo.pojo.entity.CashFlowKey;
import org.apache.ibatis.annotations.Select;

public interface CashFlowDao {
    int deleteByPrimaryKey(CashFlowKey key);

    int insert(CashFlow record);

    int insertSelective(CashFlow record);

    CashFlow selectByPrimaryKey(CashFlowKey key);

    int updateByPrimaryKeySelective(CashFlow record);

    int updateByPrimaryKey(CashFlow record);

    @Select("SELECT * FROM cash_flow order by Flow_ID desc limit 1")
    CashFlow SelectTopRecord();

}
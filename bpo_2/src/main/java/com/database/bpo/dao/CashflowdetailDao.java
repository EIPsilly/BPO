package com.database.bpo.dao;

import com.database.bpo.pojo.entity.Cashflowdetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CashflowdetailDao {

    @Select("Select * from CashFlowDetail")
    List<Cashflowdetail> SelectAll();
}
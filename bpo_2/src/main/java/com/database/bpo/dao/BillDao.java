package com.database.bpo.dao;

import com.database.bpo.pojo.entity.Bill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillDao {
    int deleteByPrimaryKey(Integer billId);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer billId);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    @Select("Select * From bill Where User_ID = #{UserId} Order By Bill_Time")
    List<Bill> SelectByUserId(Integer UserId);
}
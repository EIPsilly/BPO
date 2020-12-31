package com.database.bpo.dao;

import com.database.bpo.pojo.entity.BiddingScheme;
import com.database.bpo.pojo.entity.BiddingSchemeKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BiddingSchemeDao {
    int deleteByPrimaryKey(BiddingSchemeKey key);

    int insert(BiddingScheme record);

    int insert2(BiddingScheme record);

    int insertSelective(BiddingScheme record);

    BiddingScheme selectByPrimaryKey(BiddingSchemeKey key);

    int updateByPrimaryKeySelective(BiddingScheme record);

    int updateByPrimaryKey(BiddingScheme record);
}

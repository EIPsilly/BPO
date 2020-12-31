package com.database.bpo.service.impl;

import com.database.bpo.dao.BiddingSchemeDao;
import com.database.bpo.pojo.entity.BiddingScheme;
import com.database.bpo.service.BiddingSchemeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BiddingSchemeServiceImpl implements BiddingSchemeService {
    @Resource
    BiddingSchemeDao dao;

    @Override
    public boolean addNewBidding(BiddingScheme biddingScheme) {
        if(biddingScheme != null){
            int success = dao.insert2(biddingScheme);
            return true;
        }
        return false;
    }
}

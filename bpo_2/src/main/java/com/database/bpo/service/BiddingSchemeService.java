package com.database.bpo.service;

import com.database.bpo.pojo.entity.BiddingScheme;
import org.springframework.stereotype.Service;

@Service
public interface BiddingSchemeService {
    public boolean addNewBidding(BiddingScheme biddingScheme);
}

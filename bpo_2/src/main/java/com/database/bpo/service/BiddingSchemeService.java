package com.database.bpo.service;

import com.database.bpo.pojo.entity.BiddingScheme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BiddingSchemeService {
    public boolean addNewBidding(BiddingScheme biddingScheme);
    public List<BiddingScheme> findBiddingScheme(Integer projectId);
}

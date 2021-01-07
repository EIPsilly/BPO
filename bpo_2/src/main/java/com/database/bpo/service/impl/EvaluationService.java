package com.database.bpo.service.impl;

import com.database.bpo.dao.EvaluationDao;
import com.database.bpo.pojo.entity.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EvaluationService {

    @Autowired
    EvaluationDao evaluationDao;

    public boolean AddEvaluation(Integer userRoleId,Integer orderId,String Details){
        Evaluation evaluation = new Evaluation();
        evaluation.setUserRoleId(userRoleId);
        evaluation.setOrderId(orderId);
        evaluation.setEvaluationDetails(Details);
        evaluation.setEvaluationTime(new Date());
        evaluationDao.insert(evaluation);
        return true;
    }
}

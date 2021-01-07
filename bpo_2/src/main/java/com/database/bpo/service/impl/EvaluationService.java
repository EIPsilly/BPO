package com.database.bpo.service.impl;

import com.database.bpo.dao.EvaluationDao;
import com.database.bpo.dao.EvaluationdetailsDao;
import com.database.bpo.pojo.entity.Evaluation;
import com.database.bpo.pojo.entity.Evaluationdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    EvaluationDao evaluationDao;

    @Autowired
    EvaluationdetailsDao evaluationdetailsDao;

    public boolean AddEvaluation(Integer userRoleId,Integer orderId,String Details){
        Evaluation evaluation = new Evaluation();
        evaluation.setUserRoleId(userRoleId);
        evaluation.setOrderId(orderId);
        evaluation.setEvaluationDetails(Details);
        evaluation.setEvaluationTime(new Date());
        evaluationDao.insert(evaluation);
        return true;
    }

    public List<Evaluationdetails> SelectByUserRoleId(Integer UserRoleId){
        List<Evaluationdetails> results = evaluationdetailsDao.SelectByUserRoleId(UserRoleId);
        return results;
    }
}

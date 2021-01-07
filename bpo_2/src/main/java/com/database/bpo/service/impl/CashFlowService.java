package com.database.bpo.service.impl;

import com.database.bpo.dao.CashFlowDao;
import com.database.bpo.pojo.entity.CashFlow;
import com.database.bpo.pojo.entity.MoneyNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashFlowService {

    @Autowired
    CashFlowDao cashFlowDao;

    int TypeToNum(String type){
        if ("支付定金".equals(type)) return 1;
        else if ("支付尾款".equals(type)) return 2;
        else if ("违约扣款".equals(type)) return 3;
        else if ("违约赔偿".equals(type)) return 4;
        else if ("定金退还".equals(type)) return 5;
        else if ("全额转付".equals(type)) return 6;
        return 0;
    }

    public void AddNewCashFlow(MoneyNotification notification){
        CashFlow flow = new CashFlow();
        flow.setMoneyId(notification.getMoneyId());
        String moneyType = notification.getMoneyType();
        flow.setOrderTypeId(TypeToNum(moneyType));

        CashFlow record = cashFlowDao.SelectTopRecord();
        Float amount = notification.getAmount();
        float openBalanceIncome = record.getClosingBalanceIncome(),
                openBalanceOutcome = record.getClosingBalanceOutcome(),
                currentOccurenceAmountIncome = 0,
                currentOccurenceAmountOutcome = 0,
                accumulatedAmountIncome = record.getAccumulatedAmountIncome(),
                accumulatedAmountOutcome = record.getAccumulatedAmountOutcome(),
                closingBalanceIncome = 0,
                closingBalanceOutcome = 0;
        if ("支付定金".equals(moneyType) || "支付尾款".equals(moneyType)){

            currentOccurenceAmountIncome = amount;

            accumulatedAmountIncome += amount;

            float tmp = openBalanceIncome - openBalanceOutcome + currentOccurenceAmountIncome - currentOccurenceAmountOutcome;

            if (tmp >= 0) closingBalanceIncome = tmp;
            else closingBalanceOutcome = tmp;
        } else if ("全额转付".equals(moneyType)){
            currentOccurenceAmountOutcome = amount;

            accumulatedAmountOutcome += amount;

            float tmp = openBalanceIncome - openBalanceOutcome + currentOccurenceAmountIncome - currentOccurenceAmountOutcome;

            if (tmp >= 0) closingBalanceIncome = tmp;
            else closingBalanceOutcome = tmp;
        }

        flow.setOpenBalanceIncome(openBalanceIncome);
        flow.setOpenBalanceOutcome(openBalanceOutcome);
        flow.setCurrentOccurenceAmountIncome(currentOccurenceAmountIncome);
        flow.setCurrentOccurenceAmountOutcome(currentOccurenceAmountOutcome);
        flow.setAccumulatedAmountIncome(accumulatedAmountIncome);
        flow.setAccumulatedAmountOutcome(accumulatedAmountOutcome);
        flow.setClosingBalanceIncome(closingBalanceIncome);
        flow.setClosingBalanceOutcome(closingBalanceOutcome);

        cashFlowDao.insert(flow);
    }
}

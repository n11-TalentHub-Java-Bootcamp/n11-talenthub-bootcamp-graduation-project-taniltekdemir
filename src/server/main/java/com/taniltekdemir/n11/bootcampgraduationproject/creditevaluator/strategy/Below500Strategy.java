package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class Below500Strategy implements Strategy {
    @Override
    public EvaluationResult evaluate(Integer creditScore, BigDecimal salary, BigDecimal guarantee) {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.REJECTED);
        evaluationResult.setLimit(BigDecimal.ZERO);
        return evaluationResult;
    }
}

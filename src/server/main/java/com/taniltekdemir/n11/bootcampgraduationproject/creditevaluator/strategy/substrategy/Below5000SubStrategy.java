package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class Below5000SubStrategy implements SubStrategy {
    @Override
    public EvaluationResult evaluateSubStrategy(BigDecimal salary, BigDecimal guarantee) {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        BigDecimal limit;
        BigDecimal addLimit = BigDecimal.ZERO;
        if (guarantee != null) {
            addLimit = guarantee.divide(BigDecimal.valueOf(10));
            limit = BigDecimal.valueOf(10000).add(addLimit);
        } else {
            limit = BigDecimal.valueOf(10000);
        }
        evaluationResult.setLimit(limit);
        return evaluationResult;
    }
}

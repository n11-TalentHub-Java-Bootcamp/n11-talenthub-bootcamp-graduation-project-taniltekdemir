package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class Between5000And10000SubStrategy implements SubStrategy {
    @Override
    public EvaluationResult evaluateSubStrategy(BigDecimal salary, BigDecimal guarantee) {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        BigDecimal limit;
        BigDecimal addLimit = BigDecimal.ZERO;
        if (guarantee != null) {
            addLimit = guarantee.divide(BigDecimal.valueOf(5));
            limit = BigDecimal.valueOf(20000).add(addLimit);
        } else {
            limit = BigDecimal.valueOf(20000);
        }
        evaluationResult.setLimit(limit);
        return evaluationResult;
    }
}

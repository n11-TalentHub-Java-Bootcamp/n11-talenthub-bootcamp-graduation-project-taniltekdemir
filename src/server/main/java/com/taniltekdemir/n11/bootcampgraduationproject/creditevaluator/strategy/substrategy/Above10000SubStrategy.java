package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class Above10000SubStrategy implements SubStrategy {

    public static Long multiplier = 4L;

    @Override
    public EvaluationResult evaluateSubStrategy(BigDecimal salary, BigDecimal guarantee) {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        BigDecimal limit;
        BigDecimal addLimit = BigDecimal.ZERO;
        if (guarantee != null) {
            addLimit = guarantee.divide(BigDecimal.valueOf(4));
            limit = salary.multiply(BigDecimal.valueOf(multiplier)).divide(BigDecimal.valueOf(2)).add(addLimit);;
        } else {
            limit = salary.multiply(BigDecimal.valueOf(multiplier)).divide(BigDecimal.valueOf(2));
        }
        evaluationResult.setLimit(limit);
        return evaluationResult;
    }
}

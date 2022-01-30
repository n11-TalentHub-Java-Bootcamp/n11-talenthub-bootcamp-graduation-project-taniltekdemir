package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class Above1000Strategy implements Strategy{

    public static Long multiplier = 4L;
    @Override
    public EvaluationResult evaluate(Integer creditScore, BigDecimal salary, BigDecimal guarantee) {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        BigDecimal limit;
        BigDecimal addLimit;
        if (guarantee != null) {
            addLimit = guarantee.divide(BigDecimal.valueOf(2));
            limit = salary.multiply(BigDecimal.valueOf(multiplier)).add(addLimit);;
        } else {
            limit = salary.multiply(BigDecimal.valueOf(multiplier));
        }
        evaluationResult.setLimit(limit);
        return evaluationResult;
    }
}

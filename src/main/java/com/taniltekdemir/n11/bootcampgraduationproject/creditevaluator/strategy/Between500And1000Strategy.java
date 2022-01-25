package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.SubEvaluator;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class Between500And1000Strategy implements Strategy {

    @Override
    public EvaluationResult evaluate(Integer creditScore, BigDecimal salary, BigDecimal guarantee) {
        SubEvaluator subEvaluator = new SubEvaluator(salary, guarantee);
        return subEvaluator.executeSubStrategy();
    }
}

package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public interface SubStrategy {
    EvaluationResult evaluateSubStrategy(BigDecimal salary, BigDecimal guarantee);
}

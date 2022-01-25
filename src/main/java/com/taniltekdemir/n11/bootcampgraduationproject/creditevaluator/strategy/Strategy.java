package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public interface Strategy {
    EvaluationResult evaluate(Integer creditScore, BigDecimal salary, BigDecimal guarantee);
}

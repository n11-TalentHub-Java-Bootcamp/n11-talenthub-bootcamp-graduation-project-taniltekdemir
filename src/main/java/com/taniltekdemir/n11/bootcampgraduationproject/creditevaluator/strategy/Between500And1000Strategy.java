package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.SubStrategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class Between500And1000Strategy implements Strategy {
    private SubStrategy subStrategy;

    @Autowired
    public void setSubStrategy(SubStrategy subStrategy) {
        this.subStrategy = subStrategy;
    }


    @Override
    public EvaluationResult evaluate(Integer creditScore, BigDecimal salary, BigDecimal guarantee) {
        return subStrategy.evaluateSubStrategy(salary, guarantee);
    }
}

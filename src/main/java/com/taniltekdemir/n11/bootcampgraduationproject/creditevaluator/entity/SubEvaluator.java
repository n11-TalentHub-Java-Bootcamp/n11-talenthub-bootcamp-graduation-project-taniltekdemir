package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.Above1000Strategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.Below500Strategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.Between500And1000Strategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.Above10000SubStrategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.Below5000SubStrategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.Between5000And10000SubStrategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.SubStrategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class SubEvaluator {

    private SubStrategy subStrategy;
    private BigDecimal salary;
    private BigDecimal guarantee;

    public SubEvaluator(BigDecimal salary, BigDecimal guarantee) {
        this.salary = salary;
        this.guarantee = guarantee;


        if (salary.compareTo(BigDecimal.valueOf(5000)) < 0) {
            subStrategy = new Below5000SubStrategy();
        } else if(salary.compareTo(BigDecimal.valueOf(10000)) < 0) {
            subStrategy = new Between5000And10000SubStrategy();
        } else {
            subStrategy = new Above10000SubStrategy();
        }
    }

    public EvaluationResult executeSubStrategy() {
        return subStrategy.evaluateSubStrategy(this.salary, this.guarantee);
    }
}

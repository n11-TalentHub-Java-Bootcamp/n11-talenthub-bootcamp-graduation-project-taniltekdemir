package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.Above1000Strategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.Below500Strategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.Between500And1000Strategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.Strategy;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class Eveluator {

    private Strategy strategy;
    private Integer creditScore;
    private BigDecimal salary;
    private BigDecimal guarantee;

    public Eveluator(Integer creditScore, BigDecimal salary, BigDecimal guarantee) {
        this.creditScore = creditScore;
        this.salary = salary;
        this.guarantee = guarantee;

        if (creditScore == null) {
            throw new CommonException("Kredi skor bilgisi boş olamaz!");
        }

        if (creditScore < 500) {
            strategy = new Below500Strategy();
        } else if(creditScore<1000) {
            strategy = new Between500And1000Strategy();
        } else {
            strategy = new Above1000Strategy();
        }
    }

    public EvaluationResult executeStrategy() {
        return strategy.evaluate(this.creditScore, this.salary, this.guarantee);
    }
}

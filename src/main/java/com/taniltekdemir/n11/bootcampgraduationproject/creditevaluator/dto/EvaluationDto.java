package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EvaluationDto {

    private Integer score;
    private BigDecimal salary;
    private BigDecimal guarantee;
}
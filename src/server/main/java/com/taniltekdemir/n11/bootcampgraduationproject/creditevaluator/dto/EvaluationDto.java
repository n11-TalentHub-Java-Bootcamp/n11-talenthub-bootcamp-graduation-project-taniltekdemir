package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EvaluationDto {

    private Integer score;
    private BigDecimal salary;
    private BigDecimal guarantee;
    private BigDecimal limitOfCredit;
    private EnumEvaluateStatus evaluateStatus;
    private Long applicationId;
    private Long userId;
}

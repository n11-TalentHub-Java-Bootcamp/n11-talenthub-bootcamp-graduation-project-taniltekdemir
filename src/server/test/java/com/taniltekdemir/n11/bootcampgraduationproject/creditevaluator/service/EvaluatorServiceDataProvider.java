package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class EvaluatorServiceDataProvider {

    public static EvaluationDto getEvaluationDtoForStrategy3WithGuarantee() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(1000);
        evaluationDto.setSalary(BigDecimal.valueOf(15000));
        evaluationDto.setGuarantee(BigDecimal.valueOf(50000));
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForStrategy3WithGuarantee() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(85000));
        return evaluationResult;
    }
}

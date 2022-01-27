package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;

import java.math.BigDecimal;

public class EvaluatorServiceDataProvider {

    public static EvaluationDto getEvaluationDtoForStrategy3WithGuarantee() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(1000);
        evaluationDto.setSalary(BigDecimal.valueOf(15));
        evaluationDto.setGuarantee(BigDecimal.valueOf(50));
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForStrategy3WithGuarantee() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(85));
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForStrategy3WithGuaranteeless() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(1000);
        evaluationDto.setSalary(BigDecimal.valueOf(15));
        evaluationDto.setGuarantee(null);
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForStrategy3WithGuaranteeless() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(60));
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForStrategy1WithGuarantee() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(499);
        evaluationDto.setSalary(BigDecimal.valueOf(15));
        evaluationDto.setGuarantee(BigDecimal.valueOf(50));
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForStrategy1WithGuarantee() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.REJECTED);
        evaluationResult.setLimit(BigDecimal.ZERO);
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForStrategy1WithGuaranteeless() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(499);
        evaluationDto.setSalary(BigDecimal.valueOf(15));
        evaluationDto.setGuarantee(null);
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForStrategy1WithGuaranteeless() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.REJECTED);
        evaluationResult.setLimit(BigDecimal.ZERO);
        return evaluationResult;
    }

// score 500 testti Guarantee BigDecimal.ZERO
    public static EvaluationDto getEvaluationDtoForStrategy2WithGuaranteeless() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(500);
        evaluationDto.setSalary(BigDecimal.valueOf(50));
        evaluationDto.setGuarantee(BigDecimal.ZERO);
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForStrategy2WithGuaranteeless() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(10000));
        return evaluationResult;
    }

    // score 500 testti Guarantee null
    public static EvaluationDto getEvaluationDtoForStrategy2WithGuaranteeIsNull() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(500);
        evaluationDto.setSalary(BigDecimal.valueOf(50));
        evaluationDto.setGuarantee(null);
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForStrategy2WithGuaranteeIsNull() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(10000));
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForSubStrategy1WithGuaranteeIsNull() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(800);
        evaluationDto.setSalary(BigDecimal.valueOf(50));
        evaluationDto.setGuarantee(null);
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForSubStrategy1WithGuaranteeIsNull() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(10000));
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForSubStrategy1WithGuarantee() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(800);
        evaluationDto.setSalary(BigDecimal.valueOf(50));
        evaluationDto.setGuarantee(BigDecimal.valueOf(100));
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForSubStrategy1WithGuarantee() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(10010));
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForSubStrategy2WithGuaranteeIsNull() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(800);
        evaluationDto.setSalary(BigDecimal.valueOf(5000));
        evaluationDto.setGuarantee(null);
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForSubStrategy2WithGuaranteeIsNull() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(20000));
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForSubStrategy2WithGuarantee() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(800);
        evaluationDto.setSalary(BigDecimal.valueOf(5000));
        evaluationDto.setGuarantee(BigDecimal.valueOf(100));
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForSubStrategy2WithGuarantee() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(20020));
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForSubStrategy3WithGuaranteeIsNull() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(800);
        evaluationDto.setSalary(BigDecimal.valueOf(15000));
        evaluationDto.setGuarantee(null);
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForSubStrategy3WithGuaranteeIsNull() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(30000));
        return evaluationResult;
    }

    public static EvaluationDto getEvaluationDtoForSubStrategy3WithGuarantee() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setScore(800);
        evaluationDto.setSalary(BigDecimal.valueOf(15000));
        evaluationDto.setGuarantee(BigDecimal.valueOf(100));
        return evaluationDto;
    }

    public static EvaluationResult getEvaluationResultForSubStrategy3WithGuarantee() {
        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setEvaluateStatus(EnumEvaluateStatus.ACCEPTED);
        evaluationResult.setLimit(BigDecimal.valueOf(30025));
        return evaluationResult;
    }

    public static EvaluateReport getEvaluateReport(){
        EvaluateReport evaluateReport = new EvaluateReport();
        evaluateReport.setId(1L);
        return evaluateReport;
    }

}

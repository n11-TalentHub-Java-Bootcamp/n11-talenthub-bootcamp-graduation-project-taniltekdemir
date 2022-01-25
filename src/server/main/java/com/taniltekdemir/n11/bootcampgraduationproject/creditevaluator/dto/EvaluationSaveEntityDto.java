package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class EvaluationSaveEntityDto {

    private Long userId;
    private Long applicationId;
    private BigDecimal limitOfCredit;
    private Integer scoreOfCredit;
    @Enumerated(EnumType.STRING)
    private EnumEvaluateStatus evaluateStatus;
}

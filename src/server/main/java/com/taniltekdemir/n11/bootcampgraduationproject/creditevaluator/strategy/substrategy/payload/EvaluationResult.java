package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationResult {

    private EnumEvaluateStatus evaluateStatus;
    private BigDecimal limit;

}

package com.taniltekdemir.n11.bootcampgraduationproject.inform.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformDto {

    private String phone;
    private String email;
    private BigDecimal limit;
    @Enumerated(EnumType.STRING)
    private EnumEvaluateStatus evaluateStatus;

}

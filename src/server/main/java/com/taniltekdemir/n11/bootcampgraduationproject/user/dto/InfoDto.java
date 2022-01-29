package com.taniltekdemir.n11.bootcampgraduationproject.user.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDto {

    private String name;
    private String surname;
    private String tckn;
    private EnumEvaluateStatus evaluateStatus;
    private BigDecimal limit;
    private LocalDate recordDate;
}

package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums.EnumApplyValidity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ApplyDto {

    private Long id;
    private Long userId;
    private BigDecimal salary;
    private BigDecimal guarantee;
    private EnumApplyValidity applicationValidity;
    private Integer creditScore;
    private LocalDate applicationDate;
}

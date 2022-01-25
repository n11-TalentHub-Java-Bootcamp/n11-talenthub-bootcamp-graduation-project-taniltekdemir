package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationValidity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ApplicationDto {

    private Long id;
    private Long userId;
    private BigDecimal salary;
    private BigDecimal guarantee;
    private EnumApplicationValidity applicationValidity;
    private Integer creditScore;
    private LocalDate applicationDate;
}

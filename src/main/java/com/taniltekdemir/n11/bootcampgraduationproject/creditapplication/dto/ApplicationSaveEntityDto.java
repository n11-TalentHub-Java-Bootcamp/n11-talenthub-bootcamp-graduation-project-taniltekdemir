package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ApplicationSaveEntityDto {

    @NotNull
    private Long userId;
    @NotNull
    private BigDecimal salary;
    private BigDecimal guarantee;

}

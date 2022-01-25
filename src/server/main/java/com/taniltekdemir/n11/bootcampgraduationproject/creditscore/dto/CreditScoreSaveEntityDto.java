package com.taniltekdemir.n11.bootcampgraduationproject.creditscore.dto;

import lombok.Data;

@Data
public class CreditScoreSaveEntityDto {

    private Long userId;
    private Integer creditScore;

    public CreditScoreSaveEntityDto(Long userId, Integer creditScore) {
        this.userId = userId;
        this.creditScore = creditScore;
    }
}

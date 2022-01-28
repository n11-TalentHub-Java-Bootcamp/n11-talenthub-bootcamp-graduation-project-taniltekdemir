package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.entity.CreditApply;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums.EnumApplyValidity;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditAppServiceDataProvider {
    public static ApplySaveEntityDto getApplicationSaveEntityDto() {

        ApplySaveEntityDto saveEntityDto = new ApplySaveEntityDto();
        saveEntityDto.setUserId(1L);
        saveEntityDto.setSalary(BigDecimal.valueOf(10000));
        saveEntityDto.setGuarantee(BigDecimal.valueOf(50000));
        return saveEntityDto;
    }

    public static ApplySaveEntityDto getApplicationSaveEntityDtoForVAlidation() {

        ApplySaveEntityDto saveEntityDto = new ApplySaveEntityDto();
        saveEntityDto.setUserId(1L);
        saveEntityDto.setSalary(null);
        saveEntityDto.setGuarantee(BigDecimal.valueOf(50000));
        return saveEntityDto;
    }

    public static ApplyDto getApplicationDto() {

        ApplyDto applyDto = new ApplyDto();
        applyDto.setApplicationDate(LocalDate.now());
        applyDto.setId(1L);
        applyDto.setApplicationValidity(EnumApplyValidity.ACTIVE);
        applyDto.setUserId(1L);
        applyDto.setSalary(BigDecimal.valueOf(10000));
        applyDto.setGuarantee(BigDecimal.valueOf(50000));
        return applyDto;
    }

    public static CreditApply getCreditApplication() {

        CreditApply creditApply = new CreditApply();
        creditApply.setApplicationDate(LocalDate.now());
        creditApply.setId(1L);
        creditApply.setUser(new User(1L));
        creditApply.setApplicationValidity(EnumApplyValidity.ACTIVE);
        creditApply.setSalary(BigDecimal.valueOf(10000));
        creditApply.setGuarantee(BigDecimal.valueOf(50000));
        return creditApply;
    }
}

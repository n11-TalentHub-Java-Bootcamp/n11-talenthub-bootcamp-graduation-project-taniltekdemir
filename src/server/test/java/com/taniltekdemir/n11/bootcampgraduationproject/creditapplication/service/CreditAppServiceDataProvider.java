package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity.CreditApplication;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationValidity;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditAppServiceDataProvider {
    public static ApplicationSaveEntityDto getApplicationSaveEntityDto() {

        ApplicationSaveEntityDto saveEntityDto = new ApplicationSaveEntityDto();
        saveEntityDto.setUserId(1L);
        saveEntityDto.setSalary(BigDecimal.valueOf(10000));
        saveEntityDto.setGuarantee(BigDecimal.valueOf(50000));
        return saveEntityDto;
    }

    public static ApplicationSaveEntityDto getApplicationSaveEntityDtoForVAlidation() {

        ApplicationSaveEntityDto saveEntityDto = new ApplicationSaveEntityDto();
        saveEntityDto.setUserId(1L);
        saveEntityDto.setSalary(null);
        saveEntityDto.setGuarantee(BigDecimal.valueOf(50000));
        return saveEntityDto;
    }

    public static ApplicationDto getApplicationDto() {

        ApplicationDto applicationDto = new ApplicationDto();
        applicationDto.setApplicationDate(LocalDate.now());
        applicationDto.setId(1L);
        applicationDto.setApplicationValidity(EnumApplicationValidity.ACTIVE);
        applicationDto.setUserId(1L);
        applicationDto.setSalary(BigDecimal.valueOf(10000));
        applicationDto.setGuarantee(BigDecimal.valueOf(50000));
        return applicationDto;
    }

    public static CreditApplication getCreditApplication() {

        CreditApplication creditApplication = new CreditApplication();
        creditApplication.setApplicationDate(LocalDate.now());
        creditApplication.setId(1L);
        creditApplication.setUser(new User(1L));
        creditApplication.setApplicationValidity(EnumApplicationValidity.ACTIVE);
        creditApplication.setSalary(BigDecimal.valueOf(10000));
        creditApplication.setGuarantee(BigDecimal.valueOf(50000));
        return creditApplication;
    }
}

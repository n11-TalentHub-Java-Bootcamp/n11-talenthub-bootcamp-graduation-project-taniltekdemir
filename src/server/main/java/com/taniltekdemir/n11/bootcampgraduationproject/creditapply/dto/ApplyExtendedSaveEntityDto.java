package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.user.enums.EnumUserType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ApplyExtendedSaveEntityDto {

    @NotNull
    @Size(min = 2)
    private String name;
    @NotNull
    @Size(min = 2)
    private String surname;
    @NotNull
    @Size(min = 11, max = 11)
    private String tckn;
    @NotNull
    @Size(min = 10)
    private String telephone;
    @Email
    private String email;
    @NotNull
    private String dateOfBirth;
    private EnumUserType userType;
    @NotNull
    private BigDecimal salary;
    private BigDecimal guarantee;
}

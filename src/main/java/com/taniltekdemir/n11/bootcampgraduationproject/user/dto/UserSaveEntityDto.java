package com.taniltekdemir.n11.bootcampgraduationproject.user.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.user.enums.EnumUserType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserSaveEntityDto {

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
}

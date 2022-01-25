package com.taniltekdemir.n11.bootcampgraduationproject.user.dto;

import com.taniltekdemir.n11.bootcampgraduationproject.user.enums.EnumUserType;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String tckn;
    private String telephone;
    private String email;
    private String dateOfBirth;
    private EnumUserType userType;
}

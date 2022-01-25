package com.taniltekdemir.n11.bootcampgraduationproject.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InterrogateDto {

    @NotNull
    private String tckn;
    @NotNull
    private String dateOfBirth;
}

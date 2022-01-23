package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.mapper;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity.CreditApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditAppMapper {

    CreditAppMapper INSTANCE = Mappers.getMapper(CreditAppMapper.class);

    @Mapping(target = "user.id", source = "userId")
    CreditApplication convertApplicationSaveEntityDtoToCreditApp(ApplicationSaveEntityDto saveEntityDto);

    @Mapping(target = "userId", source = "user.id")
    ApplicationDto convertCreditApplicationToApplicationDto(CreditApplication creditApplication);

    List<ApplicationDto> convertCreditApplicationListToApplicationDtoList(List<CreditApplication> creditApplications);
}

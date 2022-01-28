package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.mapper;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.entity.CreditApply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditAppMapper {

    CreditAppMapper INSTANCE = Mappers.getMapper(CreditAppMapper.class);

    @Mapping(target = "user.id", source = "userId")
    CreditApply convertApplicationSaveEntityDtoToCreditApp(ApplySaveEntityDto saveEntityDto);

    @Mapping(target = "userId", source = "user.id")
    ApplyDto convertCreditApplicationToApplicationDto(CreditApply creditApply);

    List<ApplyDto> convertCreditApplicationListToApplicationDtoList(List<CreditApply> creditApplies);
}

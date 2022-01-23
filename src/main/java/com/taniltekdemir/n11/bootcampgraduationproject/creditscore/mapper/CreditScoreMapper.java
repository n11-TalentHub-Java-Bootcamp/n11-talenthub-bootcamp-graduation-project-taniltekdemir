package com.taniltekdemir.n11.bootcampgraduationproject.creditscore.mapper;

import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.dto.CreditScoreSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.entity.CreditScore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditScoreMapper {

    CreditScoreMapper INSTANCE = Mappers.getMapper(CreditScoreMapper.class);

    @Mapping(target = "user.id", source = "userId")
    CreditScore convertCreditScoreSaveEntityToCrediteScore(CreditScoreSaveEntityDto saveEntityDto);
}

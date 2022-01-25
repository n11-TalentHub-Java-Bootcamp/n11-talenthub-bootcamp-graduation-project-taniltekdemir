package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EvaluationMapper {
    EvaluationMapper INSTANCE = Mappers.getMapper(EvaluationMapper.class);

    @Mappings({
            @Mapping(target = "score", ignore = true),
            @Mapping(target = "applicationId", source ="id")
    })
    EvaluationDto convertApplicationDtoEvaluationDto(ApplicationDto applicationDto);

    @Mappings({
            @Mapping(target = "user.id", source ="userId"),
            @Mapping(target = "application.id", source ="applicationId")
    })
    EvaluateReport convertEvaluationSaveEntityDtoToEvaluateReport(EvaluationSaveEntityDto saveEntityDto);

}

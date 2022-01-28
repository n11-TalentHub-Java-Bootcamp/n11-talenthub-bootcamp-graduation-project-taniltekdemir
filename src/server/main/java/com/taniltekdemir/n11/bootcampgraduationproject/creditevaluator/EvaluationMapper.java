package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
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
    EvaluationDto convertApplicationDtoEvaluationDto(ApplyDto applyDto);

    @Mappings({
            @Mapping(target = "user.id", source ="userId"),
            @Mapping(target = "application.id", source ="applicationId")
    })
    EvaluateReport convertEvaluationSaveEntityDtoToEvaluateReport(EvaluationSaveEntityDto saveEntityDto);

    @Mappings({
            @Mapping(target = "scoreOfCredit", source = "evaluationDto.score"),
            @Mapping(target = "applicationId", source = "evaluationDto.applicationId"),
            @Mapping(target = "userId", source = "evaluationDto.userId"),
            @Mapping(target = "limitOfCredit", source = "evaluationResult.limit"),
            @Mapping(target = "evaluateStatus", source = "evaluationResult.evaluateStatus"),
    })
    EvaluationSaveEntityDto convertToEvaluationSaveEntityDto(EvaluationDto evaluationDto, EvaluationResult evaluationResult);

}

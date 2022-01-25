package com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service.CreditAppService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.EvaluationMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service.EvaluatorService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.service.CreditScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ManagerService {

    private final CreditAppService creditAppService;
    private final CreditScoreService creditScoreService;
    private final EvaluatorService evaluatorService;


    public EvaluationResult management(ApplicationSaveEntityDto saveEntityDto) {

        ApplicationDto applicationDto = creditAppService.createCreditApp(saveEntityDto);
        Integer creditScore = creditScoreService.findByUserId(saveEntityDto.getUserId());

        EvaluationDto evaluationDto = EvaluationMapper.INSTANCE.convertApplicationDtoEvaluationDto(applicationDto);
        evaluationDto.setScore(creditScore);
        EvaluationResult evaluationResult = evaluatorService.calculateCredit(evaluationDto);
        //inform();
        return evaluationResult;
    }

    public EvaluateReport getResultByApplicationId(Long applicationId) {

        EvaluateReport report = evaluatorService.getResult(applicationId);
        return report;
    }
}

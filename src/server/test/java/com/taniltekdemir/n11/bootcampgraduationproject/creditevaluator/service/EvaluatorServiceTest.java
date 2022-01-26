package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.repository.EvaluatorRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service.entityService.EvaluatorEntityService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EvaluatorServiceTest {

    @InjectMocks
    private EvaluatorService evaluatorService;
    @Mock
    private EvaluatorEntityService evaluatorEntityService;
    @Mock
    private EvaluatorRepository evaluatorRepository;

    @Test
    void calculateCredit() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForStrategy3WithGuarantee();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForStrategy3WithGuarantee();


    }

    @Test
    void getResult() {
    }
}
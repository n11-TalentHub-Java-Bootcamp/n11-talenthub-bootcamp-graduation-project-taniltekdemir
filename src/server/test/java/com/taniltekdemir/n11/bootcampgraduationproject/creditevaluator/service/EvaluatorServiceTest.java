package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.repository.EvaluatorRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service.entityService.EvaluatorEntityService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EvaluatorServiceTest {

    @InjectMocks
    private EvaluatorService evaluatorService;
    @Mock
    private EvaluatorEntityService evaluatorEntityService;
    @Mock
    private EvaluatorRepository evaluatorRepository;

    @Test
    void calculateCreditForStrategy3WithGurantee() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForStrategy3WithGuarantee();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForStrategy3WithGuarantee();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForStrategy3WithGuaranteeless() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForStrategy3WithGuaranteeless();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForStrategy3WithGuaranteeless();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForStrategy1WithGuarantee() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForStrategy1WithGuarantee();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForStrategy1WithGuarantee();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForStrategy1WithGuaranteeless() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForStrategy1WithGuaranteeless();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForStrategy1WithGuaranteeless();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForStrategy2WithGuaranteeless() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForStrategy2WithGuaranteeless();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForStrategy2WithGuaranteeless();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForStrategy2WithGuaranteeIsNull() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForStrategy2WithGuaranteeIsNull();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForStrategy2WithGuaranteeIsNull();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForSubStrategy1WithGuaranteeIsNull() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForSubStrategy1WithGuaranteeIsNull();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForSubStrategy1WithGuaranteeIsNull();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForSubStrategy1WithGuarantee() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForSubStrategy1WithGuarantee();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForSubStrategy1WithGuarantee();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForSubStrategy2WithGuaranteeIsNull() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForSubStrategy2WithGuaranteeIsNull();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForSubStrategy2WithGuaranteeIsNull();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForSubStrategy2WithGuarantee() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForSubStrategy2WithGuarantee();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForSubStrategy2WithGuarantee();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForSubStrategy3WithGuaranteeIsNull() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForSubStrategy3WithGuaranteeIsNull();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForSubStrategy3WithGuaranteeIsNull();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }

    @Test
    void calculateCreditForSubStrategy3WithGuarantee() {
        EvaluationDto evaluationDto = EvaluatorServiceDataProvider.getEvaluationDtoForSubStrategy3WithGuarantee();
        EvaluationResult evaluationResult = EvaluatorServiceDataProvider.getEvaluationResultForSubStrategy3WithGuarantee();

        EvaluationResult result = evaluatorService.calculateCredit(evaluationDto);

        assertEquals(evaluationResult, result);
    }


    @Test
    void getResult() {
    }
}
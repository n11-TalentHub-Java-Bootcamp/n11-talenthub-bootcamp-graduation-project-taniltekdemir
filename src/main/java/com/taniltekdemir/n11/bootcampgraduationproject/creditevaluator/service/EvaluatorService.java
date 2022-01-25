package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.EvaluationMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.Evaluator;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.repository.EvaluatorRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service.entityService.EvaluatorEntityService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class EvaluatorService {

    private final EvaluatorEntityService evaluatorEntityService;
    private final EvaluatorRepository evaluatorRepository;

    public EvaluationResult calculateCredit(EvaluationDto evaluationDto) {

        Evaluator evaluator = new Evaluator(evaluationDto.getScore(), evaluationDto.getSalary(), evaluationDto.getGuarantee());
        EvaluationResult evaluationResult = evaluator.executeStrategy();

        saveEvaluateReport(evaluationDto, evaluationResult);

        return evaluationResult;

    }

    private void saveEvaluateReport(EvaluationDto evaluationDto, EvaluationResult evaluationResult) {
        EvaluationSaveEntityDto saveEntityDto = new EvaluationSaveEntityDto();
        saveEntityDto.setScoreOfCredit(evaluationDto.getScore());
        saveEntityDto.setApplicationId(evaluationDto.getApplicationId());
        saveEntityDto.setUserId(evaluationDto.getUserId());
        saveEntityDto.setLimitOfCredit(evaluationResult.getLimit());
        saveEntityDto.setEvaluateStatus(evaluationResult.getEvaluateStatus());

        EvaluateReport report = EvaluationMapper.INSTANCE.convertEvaluationSaveEntityDtoToEvaluateReport(saveEntityDto);
        evaluatorEntityService.save(report);
    }

    public EvaluateReport getResult(Long applicationId) {
        return evaluatorRepository.findFirstByApplication_Id(applicationId);
    }
}

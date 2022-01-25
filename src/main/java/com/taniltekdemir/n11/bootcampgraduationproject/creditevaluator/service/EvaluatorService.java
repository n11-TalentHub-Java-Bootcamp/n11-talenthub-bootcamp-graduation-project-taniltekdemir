package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.Evaluator;
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

    public EvaluationResult calculate(EvaluationDto evaluationDto) {

        Evaluator evaluator = new Evaluator(evaluationDto.getScore(), evaluationDto.getSalary(), evaluationDto.getGuarantee());

        return evaluator.executeStrategy();

    }

}

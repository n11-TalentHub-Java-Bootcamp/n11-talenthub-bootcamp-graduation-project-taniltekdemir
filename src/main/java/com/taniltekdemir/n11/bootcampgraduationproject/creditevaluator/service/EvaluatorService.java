package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluatonDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.Eveluator;
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

    public EvaluationResult calculate(EvaluatonDto evaluatonDto) {

        Eveluator eveluator = new Eveluator(evaluatonDto.getScore(), evaluatonDto.getSalary(), evaluatonDto.getGuarantee());

        return eveluator.executeStrategy();

    }

}

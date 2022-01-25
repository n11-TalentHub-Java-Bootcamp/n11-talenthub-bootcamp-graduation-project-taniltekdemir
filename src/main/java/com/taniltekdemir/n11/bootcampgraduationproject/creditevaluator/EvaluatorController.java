package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service.EvaluatorService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/evaluator")
@CrossOrigin
@RequiredArgsConstructor
public class EvaluatorController {

    private final EvaluatorService evaluatorService;
    @PostMapping
    public ResponseEntity<?> first(@RequestBody EvaluationDto evaluationDto) {
        EvaluationResult calculate = evaluatorService.calculate(evaluationDto);
        return ResponseEntity.ok(calculate);
    }
}

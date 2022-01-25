package com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity.CreditApplication;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service.CreditAppService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service.EvaluatorService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.service.CreditScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/managers")
@CrossOrigin
@RequiredArgsConstructor
public class ManagerController {

    private final CreditAppService creditAppService;
    private final CreditScoreService creditScoreService;
    private final EvaluatorService evaluatorService;
}

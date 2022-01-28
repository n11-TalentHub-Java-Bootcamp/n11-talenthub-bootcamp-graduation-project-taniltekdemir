package com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service.CreditAppService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.EvaluationMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.dto.EvaluationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service.EvaluatorService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.service.CreditScoreService;
import com.taniltekdemir.n11.bootcampgraduationproject.inform.dto.InformDto;
import com.taniltekdemir.n11.bootcampgraduationproject.inform.service.InformService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagerService {

    private final CreditAppService creditAppService;
    private final CreditScoreService creditScoreService;
    private final EvaluatorService evaluatorService;
    private final InformService informService;
    private final UserService userService;

    @Transactional
    public EvaluationResult applyCredit(ApplySaveEntityDto saveEntityDto) {

            ApplyDto applyDto = creditAppService.createCreditApp(saveEntityDto);
            Integer creditScore = creditScoreService.findByUserId(saveEntityDto.getUserId());

            EvaluationDto evaluationDto = EvaluationMapper.INSTANCE.convertApplicationDtoEvaluationDto(applyDto);
            evaluationDto.setScore(creditScore);
            EvaluationResult evaluationResult = evaluatorService.calculateCredit(evaluationDto);
            inform(saveEntityDto, evaluationResult);
            return evaluationResult;
    }

    private void inform(ApplySaveEntityDto saveEntityDto, EvaluationResult evaluationResult) {
        try {
            User user = userService.findById(saveEntityDto.getUserId());
            informService.notify(new InformDto(user.getTelephone(), user.getEmail(), evaluationResult.getLimit(), evaluationResult.getEvaluateStatus()));
        } catch (Exception e) {
            log.error("Kredi sonucu bildirimi yapılamadı: {}", e.getMessage());
        }
    }

    public EvaluateReport getResultByApplicationId(Long applicationId) {
        EvaluateReport report = evaluatorService.getResult(applicationId);
        return report;
    }
}

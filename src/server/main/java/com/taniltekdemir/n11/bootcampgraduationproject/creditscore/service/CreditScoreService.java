package com.taniltekdemir.n11.bootcampgraduationproject.creditscore.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.dto.CreditScoreSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.entity.CreditScore;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.mapper.CreditScoreMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.repository.CreditScoreRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.service.entityService.CreditScoreEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class CreditScoreService {

    private final CreditScoreEntityService creditScoreEntityService;

    private final CreditScoreRepository creditScoreRepository;

    public Integer create(Long userId) {
        Integer score = getRandomNumberUsingNextInt(1, 1001);
        CreditScoreSaveEntityDto creditScoreSaveEntityDto = new CreditScoreSaveEntityDto(userId, score);
        CreditScore creditScore = CreditScoreMapper.INSTANCE.convertCreditScoreSaveEntityToCrediteScore(creditScoreSaveEntityDto);

        creditScore = creditScoreEntityService.save(creditScore);
        return creditScore.getCreditScore();
    }

    public Integer getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public Integer findByUserId(Long userId) {
        CreditScore creditScore = creditScoreRepository.findFirstByUser_Id(userId);
        if (creditScore == null) {
            return create(userId);
        }
        return creditScore.getCreditScore();
    }

    public Boolean isExistCreditScoreByUserId(Long userId) {
        CreditScore creditScore = creditScoreRepository.findFirstByUser_Id(userId);
        if (creditScore == null) {
            return false;
        }
        return true;
    }



}

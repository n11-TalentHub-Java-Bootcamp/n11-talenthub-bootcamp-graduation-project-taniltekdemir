package com.taniltekdemir.n11.bootcampgraduationproject.creditscore.service.entityService;

import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.entity.CreditScore;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.repository.CreditScoreRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.common.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreEntityService extends BaseEntityService<CreditScore, CreditScoreRepository> {
    public CreditScoreEntityService(CreditScoreRepository repository) {
        super(repository);
    }
}

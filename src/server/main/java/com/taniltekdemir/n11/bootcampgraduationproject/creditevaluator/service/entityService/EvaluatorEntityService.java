package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.service.entityService;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.repository.EvaluatorRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.common.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class EvaluatorEntityService extends BaseEntityService<EvaluateReport, EvaluatorRepository> {
    public EvaluatorEntityService(EvaluatorRepository repository) {
        super(repository);
    }
}

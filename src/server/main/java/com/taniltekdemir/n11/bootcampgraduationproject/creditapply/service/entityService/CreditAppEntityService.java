package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service.entityService;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.entity.CreditApply;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.repository.CreditAppRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.common.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CreditAppEntityService extends BaseEntityService<CreditApply, CreditAppRepository> {

    public CreditAppEntityService(CreditAppRepository repository) {
        super(repository);
    }
}

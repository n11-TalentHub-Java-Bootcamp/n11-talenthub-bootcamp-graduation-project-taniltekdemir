package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service.entityService;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity.CreditApplication;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.repository.CreditAppRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CreditAppEntityService extends BaseEntityService<CreditApplication, CreditAppRepository> {

    public CreditAppEntityService(CreditAppRepository repository) {
        super(repository);
    }
}

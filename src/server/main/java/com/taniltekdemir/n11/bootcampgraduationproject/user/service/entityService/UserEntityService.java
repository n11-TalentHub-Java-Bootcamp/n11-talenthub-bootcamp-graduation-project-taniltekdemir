package com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService;

import com.taniltekdemir.n11.bootcampgraduationproject.common.service.BaseEntityService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, UserRepository>{

    public UserEntityService(UserRepository repository) {
        super(repository);
    }

    public User findByTckn(String tckn) {
        return getRepository().findByTckn(tckn);
    }
}

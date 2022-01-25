package com.taniltekdemir.n11.bootcampgraduationproject.user.repository;

import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByTckn(String tckn);

    User findFirstByTcknAndAndDateOfBirth(String tckn, String dateOfBirth);
}

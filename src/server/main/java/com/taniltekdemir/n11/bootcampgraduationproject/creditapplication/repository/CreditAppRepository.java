package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.repository;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity.CreditApplication;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationValidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditAppRepository extends JpaRepository<CreditApplication, Long> {

    CreditApplication findFirstByUser_IdAndApplicationValidity(Long userId, EnumApplicationValidity enumApplicationValidity);

}

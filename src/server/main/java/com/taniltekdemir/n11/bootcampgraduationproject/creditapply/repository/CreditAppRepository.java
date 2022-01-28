package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.repository;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.entity.CreditApply;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums.EnumApplyValidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditAppRepository extends JpaRepository<CreditApply, Long> {

    CreditApply findFirstByUser_IdAndApplicationValidity(Long userId, EnumApplyValidity enumApplyValidity);

}

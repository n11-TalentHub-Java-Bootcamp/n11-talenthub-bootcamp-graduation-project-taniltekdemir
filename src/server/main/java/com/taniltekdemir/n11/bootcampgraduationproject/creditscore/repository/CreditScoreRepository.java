package com.taniltekdemir.n11.bootcampgraduationproject.creditscore.repository;

import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.entity.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {

    CreditScore findFirstByUser_Id(Long userId);
}

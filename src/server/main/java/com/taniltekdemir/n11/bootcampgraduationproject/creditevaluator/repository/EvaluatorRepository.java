package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.repository;

import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluatorRepository extends JpaRepository<EvaluateReport, Long> {

    EvaluateReport findFirstByApplication_Id(Long applicationId);

}

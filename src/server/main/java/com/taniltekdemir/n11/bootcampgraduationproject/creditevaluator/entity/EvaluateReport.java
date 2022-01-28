package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.entity.CreditApply;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.common.entity.BaseEntity;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name= "EVALUATE_REPORT")
@Data
public class EvaluateReport implements BaseEntity {

    @Id
    @SequenceGenerator(name = "EvaluateReport", sequenceName = "EVALUATE_REPORT_ID_SEQ")
    @GeneratedValue(generator = "EvaluateReport")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_EVALUATE_REPORT_ID"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", foreignKey = @ForeignKey(name = "FK_CREDIT_APPLICATION_EVALUATE_REPORT_ID"))
    private CreditApply application;

    @Column(name ="limt_of_credit")
    private BigDecimal limitOfCredit;

    @Column(name ="score_of_credit")
    private Integer scoreOfCredit;

    @Column(name = "status_of_evaluate")
    @Enumerated(EnumType.STRING)
    private EnumEvaluateStatus evaluateStatus;

}

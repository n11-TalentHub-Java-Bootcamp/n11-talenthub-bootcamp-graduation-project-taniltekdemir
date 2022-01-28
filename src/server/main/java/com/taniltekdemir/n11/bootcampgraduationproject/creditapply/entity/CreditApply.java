package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.entity;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums.EnumApplyStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums.EnumApplyValidity;
import com.taniltekdemir.n11.bootcampgraduationproject.common.entity.BaseEntity;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CREDIT_APPLICATION")
@Data
public class CreditApply implements BaseEntity {

    @Id
    @SequenceGenerator(name = "CreditApplication", sequenceName = "CREDIT_APPLICATION_ID_SEQ")
    @GeneratedValue(generator = "CreditApplication")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_CREDIT_APPLICATION_ID"))
    private User user;

    @Column(precision = 19, scale = 0, name = "salary")
    private BigDecimal salary;

    @Column(precision = 19, scale = 0, name = "guarantee")
    private BigDecimal guarantee;

    @Column(name = "validity_of_applicaton")
    @Enumerated(EnumType.STRING)
    private EnumApplyValidity applicationValidity;

    @Column(name = "status_of_applicaton")
    @Enumerated(EnumType.STRING)
    private EnumApplyStatus applicationStatus;

    @Transient
    @Column(name = "credit_score")
    private Integer creditScore;

    @Column(name = "application_date")
    private LocalDate applicationDate;
}

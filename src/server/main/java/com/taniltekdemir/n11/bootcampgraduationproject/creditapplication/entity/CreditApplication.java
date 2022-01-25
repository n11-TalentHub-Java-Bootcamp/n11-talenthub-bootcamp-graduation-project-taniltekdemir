package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationValidity;
import com.taniltekdemir.n11.bootcampgraduationproject.gen.entity.BaseEntity;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CREDIT_APPLICATION")
@Data
public class CreditApplication implements BaseEntity {

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
    private EnumApplicationValidity applicationValidity;

    @Column(name = "status_of_applicaton")
    @Enumerated(EnumType.STRING)
    private EnumApplicationStatus applicationStatus;

    @Transient
    @Column(name = "credit_score")
    private Integer creditScore;

    @Column(name = "application_date")
    private LocalDate applicationDate;
}

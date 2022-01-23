package com.taniltekdemir.n11.bootcampgraduationproject.creditscore.entity;

import com.taniltekdemir.n11.bootcampgraduationproject.gen.entity.BaseEntity;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT_SCORE")
@Data
public class CreditScore implements BaseEntity {

    @Id
    @SequenceGenerator(name = "CreditScore", sequenceName = "CREDIT_SCORE_ID_SEQ")
    @GeneratedValue(generator = "CreditScore")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_CREDITSCORE_ID"))
    private User user;

    @Column(name = "credit_score")
    private Integer creditScore;

}

package com.taniltekdemir.n11.bootcampgraduationproject.user.entity;

import com.taniltekdemir.n11.bootcampgraduationproject.gen.entity.BaseEntity;
import com.taniltekdemir.n11.bootcampgraduationproject.user.enums.EnumUserType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "USR_USER")
@Data
public class User implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "tckn")
    private String tckn;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "type_of_user")
    @Enumerated(EnumType.STRING)
    private EnumUserType userType;

    @Column(name = "password")
    private String password;
}

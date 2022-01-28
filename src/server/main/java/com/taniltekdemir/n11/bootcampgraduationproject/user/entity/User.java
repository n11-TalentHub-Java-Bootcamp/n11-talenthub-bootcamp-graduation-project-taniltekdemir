package com.taniltekdemir.n11.bootcampgraduationproject.user.entity;

import com.taniltekdemir.n11.bootcampgraduationproject.common.entity.BaseEntity;
import com.taniltekdemir.n11.bootcampgraduationproject.user.enums.EnumUserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "USR_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements BaseEntity {

    @Id
    @SequenceGenerator(name = "User", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "User")
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

    public User(Long id) {
        this.id = id;
    }
}

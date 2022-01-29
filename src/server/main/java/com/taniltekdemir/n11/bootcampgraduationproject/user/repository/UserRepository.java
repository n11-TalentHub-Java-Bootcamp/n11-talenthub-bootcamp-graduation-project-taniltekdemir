package com.taniltekdemir.n11.bootcampgraduationproject.user.repository;

import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.InfoDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByTckn(String tckn);

    User findFirstByTcknAndAndDateOfBirth(String tckn, String dateOfBirth);

    @Query("SELECT new com.taniltekdemir.n11.bootcampgraduationproject.user.dto.InfoDto(u.name, u.surname, u.tckn, e.evaluateStatus, e.limitOfCredit, e.application.applicationDate)" +
            " from User u " +
            "LEFT JOIN EvaluateReport e " +
            "ON u.id = e.user.id")
    List<InfoDto> getAllByInfo();
}

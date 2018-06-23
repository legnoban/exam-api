package com.exam.isr.persistence.repository;

import com.exam.isr.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query(value = "SELECT DISTINCT CAST(LOGIN_DATE_TIME as DATE) FROM LOGIN", nativeQuery = true)
    List<Date> findAllUniqueDates();
}

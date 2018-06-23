package com.exam.isr.persistence.repository;

import com.exam.isr.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query(value = "SELECT DISTINCT TO_DATE(l.login_date_time, 'yyyy-MM-dd') FROM login as l", nativeQuery = true)
    List<Object> findAllUniqueDates();
}

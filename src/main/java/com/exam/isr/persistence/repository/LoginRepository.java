package com.exam.isr.persistence.repository;

import com.exam.isr.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface LoginRepository extends PagingAndSortingRepository<Login, Long>, JpaSpecificationExecutor {

    List<Date> findAllUniqueDates();

    List<Login> findAll();
}

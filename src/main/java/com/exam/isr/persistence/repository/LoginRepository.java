package com.exam.isr.persistence.repository;

import com.exam.isr.model.Login;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "login", path = "login")
public interface LoginRepository extends PagingAndSortingRepository<Login, Long> {

//    List<String> findAllByLoginDateTime();
//
//    List<LocalDate> findAllDistinctLoginDates();
}

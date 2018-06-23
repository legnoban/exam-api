package com.exam.isr.persistence.repository;

import com.exam.isr.model.Login;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "login", path = "login")
public interface LoginRepositoryResource extends PagingAndSortingRepository<Login, Long> {

//    List<String> findAllByLoginDateTime();
//    List<LocalDate> findAllDistinctLoginDates();
//    Collection<Login> findAllUniqueDates();
}

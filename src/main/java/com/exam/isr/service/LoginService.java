package com.exam.isr.service;

import com.exam.isr.model.Login;
import com.exam.isr.persistence.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static com.exam.isr.persistence.specs.LoginSpecs.filterByAttr1;
import static com.exam.isr.persistence.specs.LoginSpecs.filterByAttr2;
import static com.exam.isr.persistence.specs.LoginSpecs.filterByAttr3;
import static org.springframework.data.jpa.domain.Specifications.where;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<Date> getAllUniqueLoginDatesAsc() {
        List<Date> dates = loginRepository.findAllUniqueDates();
        return dates;
    }

    public List<Login> getLogins(Optional<String> attr1, Optional<String> attr2, Optional<String> attr3) {
        List<Login> result;
        Specification<Login> loginSpecs = null;

        if(attr1.isPresent() && attr2.isPresent() && attr3.isPresent()){
            loginSpecs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()));
        }
        else if(attr1.isPresent() && attr2.isPresent() && !attr3.isPresent()) {
            loginSpecs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()));
        }
        else if(attr1.isPresent() && !attr2.isPresent() && attr3.isPresent()) {
            loginSpecs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr3(attr3.get()));
        }
        else if(attr1.isPresent() && !attr2.isPresent() && !attr3.isPresent()) {
            loginSpecs = where(filterByAttr1(attr1.get()));
        }
        else if(!attr1.isPresent() && attr2.isPresent() && attr3.isPresent()) {
            loginSpecs = where(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()));
        }
        else if(!attr1.isPresent() && !attr2.isPresent() && attr3.isPresent()) {
            loginSpecs = where(filterByAttr3(attr3.get()));
        }

        result =  loginRepository.findAll(loginSpecs);

        if(loginSpecs == null) {
            result = loginRepository.findAll();
        }

        return result;
    }

}

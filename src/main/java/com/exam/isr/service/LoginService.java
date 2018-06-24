package com.exam.isr.service;

import com.exam.isr.model.Login;
import com.exam.isr.persistence.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.exam.isr.persistence.specs.LoginSpecs.*;
import static org.springframework.data.jpa.domain.Specifications.where;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<Date> getAllUniqueLoginDatesAsc() {
        return loginRepository.findAllUniqueDates();
    }

    public List<Login> getLogins(Optional<String> attr1, Optional<String> attr2, Optional<String> attr3, Optional<LocalDate> start, Optional<LocalDate> end) {
        List<Login> result;
        Specification<Login> specs = null;

        //todo: Find a way to build CriteriaBuilder or the Predicate
        //todo: Split for method dates processing
        if (attr1.isPresent() && attr2.isPresent() && attr3.isPresent() && start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByStartDate(start.get()))
                    .and(filterByEndDate(end.get()));
        } else if (attr1.isPresent() && attr2.isPresent() && !attr3.isPresent() && start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()))
                    .and(filterByStartDate(start.get()))
                    .and(filterByEndDate(end.get()));
        } else if (attr1.isPresent() && !attr2.isPresent() && attr3.isPresent() && start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByStartDate(start.get()))
                    .and(filterByEndDate(end.get()));
        } else if (attr1.isPresent() && !attr2.isPresent() && !attr3.isPresent() && start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByStartDate(start.get()))
                    .and(filterByEndDate(end.get()));
        } else if (!attr1.isPresent() && attr2.isPresent() && attr3.isPresent() && start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByStartDate(start.get()))
                    .and(filterByEndDate(end.get()));
        } else if (!attr1.isPresent() && !attr2.isPresent() && attr3.isPresent() && start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr3(attr3.get()))
                    .and(filterByStartDate(start.get()))
                    .and(filterByEndDate(end.get()));
        }

        else if (attr1.isPresent() && attr2.isPresent() && attr3.isPresent() && start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByStartDate(start.get()));
        } else if (attr1.isPresent() && attr2.isPresent() && !attr3.isPresent() && start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()))
                    .and(filterByStartDate(start.get()));
        } else if (attr1.isPresent() && !attr2.isPresent() && attr3.isPresent() && start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByStartDate(start.get()));
        } else if (attr1.isPresent() && !attr2.isPresent() && !attr3.isPresent() && start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByStartDate(start.get()));
        } else if (!attr1.isPresent() && attr2.isPresent() && attr3.isPresent() && start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByStartDate(start.get()));
        } else if (!attr1.isPresent() && !attr2.isPresent() && attr3.isPresent() && start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr3(attr3.get()))
                    .and(filterByStartDate(start.get()));
        }

        else if (attr1.isPresent() && attr2.isPresent() && attr3.isPresent() && !start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByEndDate(end.get()));
        } else if (attr1.isPresent() && attr2.isPresent() && !attr3.isPresent() && !start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()))
                    .and(filterByEndDate(end.get()));
        } else if (attr1.isPresent() && !attr2.isPresent() && attr3.isPresent() && !start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByEndDate(end.get()));
        } else if (attr1.isPresent() && !attr2.isPresent() && !attr3.isPresent() && !start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByEndDate(end.get()));
        } else if (!attr1.isPresent() && attr2.isPresent() && attr3.isPresent() && !start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()))
                    .and(filterByEndDate(end.get()));
        } else if (!attr1.isPresent() && !attr2.isPresent() && attr3.isPresent() && !start.isPresent() && end.isPresent()) {
            specs = where(filterByAttr3(attr3.get()))
                    .and(filterByEndDate(end.get()));
        }
        else if (attr1.isPresent() && attr2.isPresent() && attr3.isPresent() && !start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()));
        } else if (attr1.isPresent() && attr2.isPresent() && !attr3.isPresent() && !start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr2(attr2.get()));
        } else if (attr1.isPresent() && !attr2.isPresent() && attr3.isPresent() && !start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()))
                    .and(filterByAttr3(attr3.get()));
        } else if (attr1.isPresent() && !attr2.isPresent() && !attr3.isPresent() && !start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr1(attr1.get()));
        } else if (!attr1.isPresent() && attr2.isPresent() && attr3.isPresent() && !start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr2(attr2.get()))
                    .and(filterByAttr3(attr3.get()));
        } else if (!attr1.isPresent() && !attr2.isPresent() && attr3.isPresent() && !start.isPresent() && !end.isPresent()) {
            specs = where(filterByAttr3(attr3.get()));
        }

        result = loginRepository.findAll(specs);

        if (specs == null) {
            result = loginRepository.findAll();
        }

        return result;
    }

}

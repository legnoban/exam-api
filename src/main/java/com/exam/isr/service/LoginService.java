package com.exam.isr.service;

import com.exam.isr.persistence.repository.LoginRepository;
import com.exam.isr.persistence.repository.LoginRepositoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class LoginService {

    private LoginRepositoryResource loginRepositoryResource;
    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepositoryResource loginRepositoryResource, LoginRepository loginRepository) {
        this.loginRepositoryResource = loginRepositoryResource;
        this.loginRepository = loginRepository;
    }

    public List<Date> getAllUniqueLoginDates() {
        List<Date> dates = loginRepository.findAllUniqueDates();
        return dates;
    }

}

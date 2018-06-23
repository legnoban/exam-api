package com.exam.isr.service;

import com.exam.isr.persistence.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public String test() {
        return "test login";
    }

    public List<String> getDistinctLoginDates() {
//        return loginRepository.findAllByLoginDateTime();
        return new ArrayList<>();
    }

    public List<LocalDate> getAllUniqueLoginDates() {
//        return loginRepository.findAllDistinctLoginDates();
        return new ArrayList<>();
    }

}

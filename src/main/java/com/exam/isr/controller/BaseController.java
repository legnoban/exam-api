package com.exam.isr.controller;

import com.exam.isr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;

import java.time.LocalDate;
import java.util.List;

@BasePathAwareController
public class BaseController {

    //TODO http://server/test/dates
    //Retrieves a JSON array of all the unique dates (ignoring time) in the table
    //The resulting JSON array needs to be sorted ascending
    private LoginService loginService;

    @Autowired
    public BaseController(LoginService loginService) {
        this.loginService = loginService;
    }

    public List<LocalDate> getAllUniqueLoginDates() {
        return loginService.getAllUniqueLoginDates();
    }
}

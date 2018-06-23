package com.exam.isr.controller;

import com.exam.isr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @GetMapping("/aa")
    public List<Object> getAllUniqueLoginDates() {
        return loginService.getAllUniqueLoginDates();
    }
}

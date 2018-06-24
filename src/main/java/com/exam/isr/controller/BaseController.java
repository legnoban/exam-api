package com.exam.isr.controller;

import com.exam.isr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@BasePathAwareController
public class BaseController {

    private LoginService loginService;

    @Autowired
    public BaseController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/dates")
    public ResponseEntity<List<String>> getAllUniqueLoginDates() {
        List<Date> result = loginService.getAllUniqueLoginDatesAsc();
        List<String> resultStr = result.stream().map( r -> r.toString()).collect(Collectors.toList());
        return new ResponseEntity<>(resultStr, HttpStatus.OK);
    }
}

package com.exam.isr.controller;

import com.exam.isr.model.Login;
import com.exam.isr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static util.DateParser.parseDate;

@BasePathAwareController
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ResponseEntity<List<Login>> getLogins(
            @RequestParam(value = "attribute1", required= false) String attribute1,
            @RequestParam(value = "attribute2", required = false) String attribute2,
            @RequestParam(value = "attribute3", required = false) String attribute3,
            @RequestParam(value = "start", required = false) String start,
            @RequestParam(value = "end", required = false) String end) {

        Optional<LocalDate> optionalStartDate = parseDate(start);
        Optional<LocalDate> optionalEndDate = parseDate(end);

        List<Login> result = loginService.getLogins(Optional.ofNullable(attribute1), Optional.ofNullable(attribute2), Optional.ofNullable(attribute3), optionalStartDate, optionalEndDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}

package com.exam.isr.controller;

import com.exam.isr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;

@BasePathAwareController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user")
//    public ResponseEntity<List<User>> getLogins(
//            @RequestParam(value = "start", required = false) String loginDateStart,
//            @RequestParam(value = "end", required = false) String loginDateEnd) {
//
//        Optional<LocalDate> optionalLoginStartDate = parseDate(loginDateStart);
//        Optional<LocalDate> optionalLoginEndDate = parseDate(loginDateEnd);
//
//        List<User> result = userService.getUsersByLoginDate(optionalLoginStartDate, optionalLoginEndDate);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
}


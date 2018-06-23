package com.exam.isr.controller;

import com.exam.isr.model.Login;
import com.exam.isr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//TOD http://server/test/logins?start=YYYYMMDD&end=YYYYMMDD&attribute1=AAA&attribute2=BBB&attribute3=CCC&attribute4=DDD
//Retrieves a JSON object where the key is the user name and the value is the number of times a user logged on between the start and the end date.
//All parameters are optional.
//The values used for the attributes are used as filters, i.e. only the records should be counted for which the attribute values are equal to the ones specified in the parameters.
//For one attribute, multiple values might be present, e.g.
// http://server/test/logins?attribute1=AA1&attribute1=AA2&attribute1=AA3

@BasePathAwareController
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController (LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("dates")
    public List<String> getLoginDates() {
        return loginService.getDistinctLoginDates();
    }


}

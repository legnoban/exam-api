package com.exam.isr.controller;

import org.springframework.data.rest.webmvc.BasePathAwareController;

//TODO http://server/test/users?start=YYYYMMDD&end=YYYYMMDD
//Retrieves a JSON array of all the unique users for which there is a login record between the start and end date.
//Both parameters are optional, so there can be a start date, an end date, or both.
//The resulting JSON array needs to be sorted ascending.

@BasePathAwareController
public class UserController {

}


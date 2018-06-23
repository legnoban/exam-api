package com.exam.isr.persistence.repository;

import com.exam.isr.model.Login;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "dateOnly", types = Login.class)
public interface DateOnly {

    @Value("#{target.loginDateTime.toLocalDate()}") // move this operation to DB?
    LocalDate getLoginDate();

}

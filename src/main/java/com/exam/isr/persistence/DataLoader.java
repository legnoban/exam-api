package com.exam.isr.persistence;

import com.exam.isr.model.Login;
import com.exam.isr.model.User;
import com.exam.isr.persistence.repository.LoginRepository;
import com.exam.isr.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

@Component
public class DataLoader implements ApplicationRunner {

    //todo: move this to test

    private LoginRepository loginRepository;
    private UserRepository userRepository;

    @Autowired
    public DataLoader(LoginRepository loginRepository, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 01, 02, 03, 05);
        for(int i=0; i<50_000; i++) {
            localDateTime = localDateTime.plus(2, ChronoUnit.WEEKS);
            User user = userRepository.save(new User("ewef", "eowoe@gmail.com"));
            Login login = new Login(localDateTime, user);
            login.setAttribute1("attrA");
            login.setAttribute2("attrB");
            login.setAttribute3("attrC  ");
            loginRepository.save(login);
        }

        for(int i=0; i<50_000; i++) {
            localDateTime = localDateTime.plus(2, ChronoUnit.MONTHS);
            User user = userRepository.save(new User("jogowo", "yeoow@gmail.com"));
            Login login = new Login(localDateTime, user);
            login.setAttribute1("attrX");
            login.setAttribute3("attrZ");
            loginRepository.save(login);
        }

        for(int i=0; i<50_000; i++) {
            localDateTime = localDateTime.plus(2, ChronoUnit.MONTHS);
            User user = userRepository.save(new User("iooow", "ppooe@gmail.com"));
            Login login = new Login(localDateTime, user);
            login.setAttribute1("attrX");
            login.setAttribute3("attrC");
            loginRepository.save(login);
        }

        for(int i=0; i<50_000; i++) {
            localDateTime = localDateTime.plus(2, ChronoUnit.MONTHS);
            User user = userRepository.save(new User("goowoe", "ppooe@yeoow.com"));
            Login login = new Login(localDateTime, user);
            login.setAttribute2("attrF");
            loginRepository.save(login);
        }

    }
}

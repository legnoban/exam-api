package com.exam.isr.service;

import com.exam.isr.model.User;
import com.exam.isr.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.exam.isr.persistence.specs.UserSpecs.filterByLoginEndDate;
import static com.exam.isr.persistence.specs.UserSpecs.filterByLoginStartDate;
import static org.springframework.data.jpa.domain.Specifications.where;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsersByLoginDate(Optional<LocalDate> start, Optional<LocalDate> end) {
        List<User> result;
        Specification<User> specs = null;


        if(start.isPresent() && end.isPresent()) {
            specs = where(filterByLoginStartDate(start.get()))
                    .and(filterByLoginEndDate(end.get()));
        }
        else if(start.isPresent() && !end.isPresent()) {
            specs = where(filterByLoginStartDate(start.get()));
        }
        else if(!start.isPresent() && end.isPresent()) {
            specs = where(filterByLoginEndDate(start.get()));
        }

        result = userRepository.findAll(specs);

        if (specs == null) {
            result = userRepository.findAll();
        }

        return result;
    }
}

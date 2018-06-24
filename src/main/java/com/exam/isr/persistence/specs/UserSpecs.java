package com.exam.isr.persistence.specs;

import com.exam.isr.model.User;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class UserSpecs {

    public static Specification<User> filterByLoginStartDate(LocalDate date) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("login").get("loginDateTime"), date.atStartOfDay());
    }

    public static Specification<User> filterByLoginEndDate(LocalDate date) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("loginDateTime").get("loginDateTime"), date.atStartOfDay());
    }

}

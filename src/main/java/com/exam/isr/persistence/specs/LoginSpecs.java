package com.exam.isr.persistence.specs;

import com.exam.isr.model.Login;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class LoginSpecs {

    public static Specification<Login> filterByAttr1(String value) {
        return equalsAttribute("attribute1", value);
    }

    public static Specification<Login> filterByAttr2(String value) {
        return equalsAttribute("attribute2", value);
    }

    public static Specification<Login> filterByAttr3(String value) {
        return equalsAttribute("attribute3", value);
    }

    public static Specification<Login> filterByStartDate(LocalDate date) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("loginDateTime"), date.atStartOfDay());
    }

    public static Specification<Login> filterByEndDate(LocalDate date) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("loginDateTime"), date.atStartOfDay());
    }

    private static Specification<Login> equalsAttribute(String columnName, String value) {
        return (root, query, builder) -> builder.equal(root.get(columnName), value);
    }

}

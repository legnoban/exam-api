package com.exam.isr.persistence.specs;

import com.exam.isr.model.Login;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.function.Predicate;

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

    private static Specification<Login> equalsAttribute(String columnName, String value) {
        return (root, query, builder) -> builder.equal(root.get(columnName), value);
    }
}

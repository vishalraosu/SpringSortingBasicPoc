package com.example.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomerListValidator.class)
public @interface ValidCustomerList {
    String message() default "Invalid user list";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


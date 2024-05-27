package com.neosoft.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailAnnotation {

	String message() default "email regex invalid";
	
	Class<?>[] groups() default {};
	
	 Class<? extends Payload>[] payload() default {};
	
}

package com.snkit.springbootdemo;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR })
@Constraint(validatedBy=DemoLongValidatorImplmenation.class)
public @interface DemoLongValidator {
	
	String message() default " Enter valid id from Demo Long validator";
	
	int size() default 0;
	
	String expression();
	
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}

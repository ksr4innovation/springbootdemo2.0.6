package com.snkit.springbootdemo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DemoLongValidatorImplmenation implements
						ConstraintValidator<DemoLongValidator, Long> {
	
	int size ;
	String regExp;

	@Override
	public void initialize(DemoLongValidator constraintAnnotation) {
		this.size = constraintAnnotation.size();
		this.regExp = constraintAnnotation.expression();
				
	}
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		
		if (value != null ) {			
			return String.valueOf(value).matches(regExp)&&
					String.valueOf(value).length()<=size;
		}
		
		return true;
	}

}

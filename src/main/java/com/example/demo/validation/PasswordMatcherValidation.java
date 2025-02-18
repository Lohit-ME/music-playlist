package com.example.demo.validation;

import com.example.demo.model.User;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatcherValidation implements ConstraintValidator<PasswordMatcher, User>{
	
	@Override
    public void initialize(PasswordMatcher constraintAnnotation) {
        // Initialization can be left empty
    }

    
    @Override
    public boolean isValid(User user,ConstraintValidatorContext context) {
    	return user.isPasswordMatching();
    	
    }
    

}

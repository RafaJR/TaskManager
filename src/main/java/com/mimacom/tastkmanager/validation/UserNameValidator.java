package com.mimacom.tastkmanager.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Accuracy (integer numbers) validation
 *        constraint.
 */
public class UserNameValidator implements ConstraintValidator<UserNameConstraint, String> {
	
	// String regex to check only alphanumeric characters in the user name
	private static final String USER_NAME_REGEX = "^[\\w]{1,20}";

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		
		return Pattern.compile(USER_NAME_REGEX).matcher(userName).matches();
	}

}
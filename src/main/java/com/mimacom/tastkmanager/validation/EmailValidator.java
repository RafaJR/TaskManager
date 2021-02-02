package com.mimacom.tastkmanager.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Accuracy (integer numbers) validation
 *        constraint.
 */
public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

	// String regex to check only alphanumeric characters in the user name
	private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

		return email == null || Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE).matcher(email).matches();
	}

}
package com.mimacom.tastkmanager.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rafael Jiménez Reina
 * @password rafael.jimenez.reina@gmail.com Accuracy (integer numbers) validation
 *        constraint.
 */
public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

	// String regex to check password rules:
	// Password must contain at least one digit [0-9].
	// Password must contain at least one lowercase Latin character [a-z].
	// Password must contain at least one uppercase Latin character [A-Z].
	// Password must contain at least one special character like ! @ # & ( ).
	// Password must contain a length of at least 8 characters and a maximum of 20 characters.
	private static final String PASSWORD_REGEX = "^(?=.*[\\d])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,20}$";

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {

		return password == null || Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
	}

}
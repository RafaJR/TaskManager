package com.mimacom.tastkmanager.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Accuracy (integer numbers) validation
 *        constraint.
 */
public class TaskNameValidator implements ConstraintValidator<TaskNameConstraint, String> {
	
	// String regex to check only alphanumeric characters in the user name
	private static final String TASK_NAME_REGEX = "^[\\w]{1,50}";

	@Override
	public boolean isValid(String taskName, ConstraintValidatorContext context) {
		
		return Pattern.compile(TASK_NAME_REGEX).matcher(taskName).matches();
	}

}
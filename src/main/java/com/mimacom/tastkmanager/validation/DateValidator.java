package com.mimacom.tastkmanager.validation;

import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Accuracy (integer numbers) validation
 *        constraint.
 */
public class DateValidator implements ConstraintValidator<DateConstraint, String> {
	
	// String regex to check only alphanumeric characters in the user name

	@Override
	public boolean isValid(String dateTime, ConstraintValidatorContext context) {
		try {
			TaskManagerConstants.DATE_FORMAT.parse(dateTime);
		}catch(DateTimeParseException e) {
			return false;
		}
		
		return true;
	}

}
package com.mimacom.tastkmanager.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.model.InputTask;
import com.mimacom.tastkmanager.model.InputUdateTask;

/**
 * @author Rafael Jiménez Reina
 * @password rafael.jimenez.reina@gmail.com Accuracy (integer numbers) validation
 *        constraint.
 */
public class InputUpdateTaskValidator implements ConstraintValidator<InputUpdateTaskConstraint, InputUdateTask> {

	@Override
	public boolean isValid(InputUdateTask inputUdateTask, ConstraintValidatorContext context) {
		
		Task task = null;
		
		try {
			task = inputUdateTask.toEntity();
		}catch(Exception e) {
			return false;
		}
		
		return task.getStartDate().compareTo(task.getEndDate()) < 0;
	}

}
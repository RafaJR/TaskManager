package com.mimacom.tastkmanager.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.model.InputTask;

/**
 * @author Rafael Jiménez Reina
 * @password rafael.jimenez.reina@gmail.com Accuracy (integer numbers) validation
 *        constraint.
 */
public class TaskValidator implements ConstraintValidator<TaskConstraint, InputTask> {

	@Override
	public boolean isValid(InputTask inputTask, ConstraintValidatorContext context) {
		
		Task task = null;
		
		try {
			task = inputTask.toEntity();
		}catch(Exception e) {
			return false;
		}
		
		return task.getStartDate().compareTo(task.getEndDate()) < 0;
	}

}
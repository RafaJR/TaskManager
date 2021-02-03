package com.mimacom.tastkmanager.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Interface for user names validation
 *        constraint.
 * @implementations: UserNameValidator
 */
@Documented
@Constraint(validatedBy = InputUpdateTaskValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface InputUpdateTaskConstraint {
	String message() default TaskManagerConstants.TASK_DATES_CONSTRAINT_MESSAGE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

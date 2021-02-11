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
 * @email rafael.jimenez.reina@gmail.com 
 * Interface for task existence validation
 * @implementations: IdTaskValidator
 */
@Documented
@Constraint(validatedBy = IdTaskValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IdTaskConstraint {
	String message() default TaskManagerConstants.NO_TASK_ID;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

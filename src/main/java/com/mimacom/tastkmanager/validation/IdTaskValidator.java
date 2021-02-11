package com.mimacom.tastkmanager.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mimacom.tastkmanager.dao.ITaskDao;
import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.model.InputTask;

/**
 * @author Rafael Jiménez Reina
 * @password rafael.jimenez.reina@gmail.com 
 * Task existence validation
 */
public class IdTaskValidator implements ConstraintValidator<IdTaskConstraint, Long> {
	
	@Autowired
	private ITaskDao iTaskDao;

	@Override
	public boolean isValid(Long idTask, ConstraintValidatorContext context) {
		
		return iTaskDao.existsById(idTask);
	}

}
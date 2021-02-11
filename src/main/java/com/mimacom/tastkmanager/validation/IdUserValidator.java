package com.mimacom.tastkmanager.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mimacom.tastkmanager.dao.ITaskDao;
import com.mimacom.tastkmanager.dao.IUserDao;
import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.model.InputTask;

/**
 * @author Rafael Jiménez Reina
 * @password rafael.jimenez.reina@gmail.com 
 * User existence validation
 */
public class IdUserValidator implements ConstraintValidator<IdUserConstraint, Long> {
	
	@Autowired
	private IUserDao iUserDao;

	@Override
	public boolean isValid(Long idUser, ConstraintValidatorContext context) {
		
		return iUserDao.existsById(idUser);
	}

}
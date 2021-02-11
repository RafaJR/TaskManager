package com.mimacom.tastkmanager.model;

import javax.validation.constraints.NotNull;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.entities.User;
import com.mimacom.tastkmanager.validation.EmailConstraint;
import com.mimacom.tastkmanager.validation.PasswordConstraint;
import com.mimacom.tastkmanager.validation.UserNameConstraint;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.ToString.Exclude;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Input user model
 */

@Data
@ToString(exclude = { "userPassword" })
@Builder
public class InputUser {

	@NotNull(message = TaskManagerConstants.NOT_NULL_USER_NAME)
	@UserNameConstraint(message = TaskManagerConstants.USER_NAME_CONSTRAINT_MESSAGE)
	private String userName;
	@EmailConstraint(message = TaskManagerConstants.EMAIL_CONSTRAINT_MESSAGE)
	private String userEmail;
	@NotNull(message = TaskManagerConstants.NOT_NULL_PASSWORD)
	@PasswordConstraint(message = TaskManagerConstants.PASSWORD_CONSTRAINT_MESSAGE)
	private String userPassword;

	// Conversion from input to entity to save in database
	public User toEntity() {

		return User.builder().userName(userName).userEmail(userEmail).userPassword(userPassword).build();
	}

}
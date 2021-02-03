package com.mimacom.tastkmanager.constants;

import java.time.format.DateTimeFormatter;

public class TaskManagerConstants {
	
	
	// Date format
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	// Process trace messages
	public static final String NEW_USER = "A new user (%s) has been saved";
	public static final String NEW_TASK = "A new task (%s) has been saved";
	
	// Input constraints messages
	public static final String NOT_NULL_USER_NAME = "The user name can not be null";
	public static final String NOT_NULL_TASK_NAME = "The task name can not be null";
	public static final String NOT_NULL_START_DATE = "The start date can not be null";
	public static final String NOT_NULL_END_DATE = "The start date can not be null";
	public static final String USER_NAME_CONSTRAINT_MESSAGE = "There is an error at the user name field."
	+ "The user name can only contain a maximum of 20 alphanumeric characters"
	+ " between uppercase or lowercase letters, numbers from 0 to 9, and '_' character.";
	public static final String TASK_NAME_CONSTRAINT_MESSAGE = "There is an error at the task name field."
			+ "The username can only contain a maximum of 50 alphanumeric characters"
			+ " between uppercase or lowercase letters, numbers from 0 to 9, and '_' character.";
	public static final String EMAIL_CONSTRAINT_MESSAGE = "The email field must be introduced with email format 'user@domain.dom'";
	public static final String NOT_NULL_PASSWORD = "The user password can not be null";
	public static final String PASSWORD_CONSTRAINT_MESSAGE = "The user password must follow these rules:\n"
			+ "\t- Password must contain at least one digit [0-9].\n"
			+ "\t- Password must contain at least one lowercase Latin character [a-z].\n"
			+ "\t- Password must contain at least one uppercase Latin character [A-Z].\n"
			+ "\t- Password must contain at least one special character like ! @ # & ( ).\n"
			+ "\t- Password must contain a length of at least 8 characters and a maximum of 20 characters.";
	public static final String DATE_CONSTRAINT_MESSAGE = "The dates must be introduced with format 'dd/MM/yyyy HH:mm'";
	public static final String TASK_DATES_CONSTRAINT_MESSAGE = "The start date must be before de end date";
	
	
	// DAO error messages
	public static final String SAVING_USER_ERROR_MESSAGE = "An error happened saving the user %s in database";
	public static final String SAVING_TASK_ERROR_MESSAGE = "An error happened saving the task %s in database";
	
	
}
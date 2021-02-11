package com.mimacom.tastkmanager.constants;

import java.time.format.DateTimeFormatter;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * General constants for the API.
 */

public class TaskManagerConstants {
	
	
	// Date format
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	// Process trace messages
	public static final String TASK_MANAGER_START = "Task Manager API is starting";
	public static final String TASK_MANAGER_STARTED = "Task Manager API is runing";
	public static final String NEW_USER = "A new user '%s' has been saved";
	public static final String NEW_TASK = "A new task '%s' has been saved";
	public static final String USER_TASKS_NOT_FOUND = "Tasks for user '%s' not found";
	public static final String UPDATED_TASK = "The task '%s' has been updated";
	public static final String FINISHED_TASK = "The task '%s' has been finished";
	public static final String DELETED_TASK = "The task '%s' has been deleted";
	public static final String DELETED_USER = "The task '%s' has been deleted";
	public static final String DELETING_USER = "The user '%s' is going to be deleted.";
	public static final String DELETING_TASK = "The task '%s' is going to be deleted.";
	public static final String FINISHING_TASK = "The task '%s' is going to be finished.";
	public static final String UPDATING_TASK = "The task '%s' is going to be updated.";
	public static final String GETTING_TASK_BY_USER = "Obtaining tasks from user '%s'";
	public static final String CREATING_NEW_TASK = "Creating new task '%s'";
	public static final String CREATING_NEW_USER = "Creating new user '%s'";
	public static final String DAO_FIND_TASK_BY_ID = "Getting task '%s' form database by ID";
	public static final String DAO_DELETING_USER_BY_ID = "Deleting user '%s' from database";
	public static final String DAO_DELETING_TASK_BY_ID = "Deleting task '%s' from database";
	public static final String DAO_DELETING_TASK_BY_ID_ERROR = "An error happened when deleting task '%s' from database";
	public static final String DAO_FINISHING_TASK = "The task '%s' is going to be finished";
	public static final String DAO_FINISHING_TASK_NOT_FOUND = "The task '%s' could not be found to be finished";
	public static final String DAO_UPDATING_TASK  = "The task '%s' is going to be updated";
	public static final String DAO_GETTING_TASK_FROM_USER = "Getting tasks from user '%s'";
	public static final String DAO_GETTING_TASK_USER_NOT_FOUND = "User '%s' could not be found.";
	public static final String DAO_NO_TASKS_FOR_USER = "Not found tasks for user '%s'";
	public static final String DAO_CREATING_USER = "Creating user '%s'";
	public static final String DAO_CREATING_TASK = "Creating task '%s'";	
//	public static final String  = "";
	
	
	// Input constraints messages
	public static final String NOT_NULL_USER_NAME = "The user name can not be null";
	public static final String NOT_NULL_TASK_NAME = "The task name can not be null";
	public static final String NOT_NULL_START_DATE = "The start date can not be null";
	public static final String NOT_NULL_END_DATE = "The start date can not be null";
	public static final String NOT_NULL_USER = "The user to save can't be null";
	public static final String NOT_NULL_TASK = "The task to save can't be null";
	public static final String NOT_NULL_TASK_ID = "The task id can not be null";
	public static final String NOT_NULL_USER_ID = "The user id can not be null";
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
	public static final String NO_TASK_ID = "Not found task";
	public static final String NO_USER_ID = "Not found user";
	
	// DAO error messages
	public static final String SAVING_USER_ERROR_MESSAGE = "An error happened saving the user %s in database";
	public static final String SAVING_TASK_ERROR_MESSAGE = "An error happened saving the task %s in database";
	public static final String UPDATING_TASK_ERROR_MESSAGE = "An error happened updating task %s in database";
	public static final String FINISHING_TASK_ERROR_MESSAGE = "An error happened finishing task %s in database";
	public static final String DELETING_TASK_ERROR_MESSAGE = "An error happened deleting task %s in database";
	public static final String DELETING_USER_ERROR_MESSAGE = "An error happened deleting user %s in database";
	
	
}
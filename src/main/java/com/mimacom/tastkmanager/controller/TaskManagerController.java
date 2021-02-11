package com.mimacom.tastkmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.model.InputTask;
import com.mimacom.tastkmanager.model.InputUdateTask;
import com.mimacom.tastkmanager.model.InputUser;
import com.mimacom.tastkmanager.model.OutputTask;
import com.mimacom.tastkmanager.service.TaskManagerServiceImpl;
import com.mimacom.tastkmanager.validation.IdTaskConstraint;
import com.mimacom.tastkmanager.validation.IdUserConstraint;
import com.mimacom.tastkmanager.validation.InputUpdateTaskConstraint;
import com.mimacom.tastkmanager.validation.TaskConstraint;
import com.mimacom.tastkmanager.validation.UserNameConstraint;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Main controller for Task Manager
 */
@RestController
@Validated
@RequestMapping("/taskmanager")
@Slf4j
public class TaskManagerController {

	@Autowired
	TaskManagerServiceImpl taskManagerService;

	/**
	 * @param userName
	 * @return ResponseEntity Obtaining task by User endpoint
	 */
	@GetMapping("/getUserTasks")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getUserTasks(
			@NotNull(message = TaskManagerConstants.NOT_NULL_USER) @UserNameConstraint String userName)
			throws IllegalArgumentException {

		log.info(String.format(TaskManagerConstants.GETTING_TASK_BY_USER, userName));

		Optional<List<OutputTask>> optListOutputTask = Optional.ofNullable(taskManagerService.getUserTasks(userName));

		return optListOutputTask.isPresent()
				? new ResponseEntity<List<OutputTask>>(optListOutputTask.get(), HttpStatus.OK)
				: new ResponseEntity<String>(String.format(TaskManagerConstants.USER_TASKS_NOT_FOUND, userName),
						HttpStatus.NOT_FOUND);

	}

	/**
	 * @param inputTask
	 * @return ResponseEntity Creating new task endpoint
	 */
	@PostMapping("/saveTask")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> saveTask(
			@RequestBody @NotNull(message = TaskManagerConstants.NOT_NULL_TASK) @Valid @TaskConstraint InputTask inputTask)
			throws IllegalArgumentException {

		log.info(String.format(TaskManagerConstants.CREATING_NEW_TASK, inputTask.toString()));

		return taskManagerService.saveTask(inputTask)
				? new ResponseEntity<String>(String.format(TaskManagerConstants.NEW_TASK, inputTask.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.SAVING_TASK_ERROR_MESSAGE, inputTask.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @param inputUser
	 * @return ResponseEntity Creating new user endpoint
	 */
	@PostMapping("/saveUser")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> saveUser(
			@RequestBody @NotNull(message = TaskManagerConstants.NOT_NULL_USER) @Valid InputUser inputUser)
			throws IllegalArgumentException {

		log.info(String.format(TaskManagerConstants.CREATING_NEW_USER, inputUser.toString()));

		return taskManagerService.saveUser(inputUser)
				? new ResponseEntity<String>(String.format(TaskManagerConstants.NEW_USER, inputUser.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.SAVING_USER_ERROR_MESSAGE, inputUser.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * @param inputUdateTask
	 * @return ResponseEntity Updating task endpoint
	 */
	@PutMapping("/updateTask")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> updateTask(
			@RequestBody @NotNull(message = TaskManagerConstants.NOT_NULL_TASK) @Valid /* @InputUpdateTaskConstraint */ InputUdateTask inputUdateTask)
			throws IllegalArgumentException {

		log.info(String.format(TaskManagerConstants.UPDATING_TASK, inputUdateTask.toString()));

		boolean update = taskManagerService.updateTask(inputUdateTask);

		return update
				? new ResponseEntity<String>(
						String.format(TaskManagerConstants.UPDATED_TASK, inputUdateTask.toString()), HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.UPDATING_TASK_ERROR_MESSAGE, inputUdateTask.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * @param idUser
	 * @returnResponseEntity Delete user by id point
	 */
	@DeleteMapping("/deleteUser")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> deleteUser(
			@NotNull(message = TaskManagerConstants.NOT_NULL_USER_ID) @IdUserConstraint Long idUser)
			throws IllegalArgumentException {

		log.info(String.format(TaskManagerConstants.DELETING_USER, idUser.toString()));

		boolean deletedTask = taskManagerService.deleteUser(idUser);

		return deletedTask
				? new ResponseEntity<String>(String.format(TaskManagerConstants.DELETED_USER, idUser.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.DELETING_USER_ERROR_MESSAGE, idUser.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * @param idTask
	 * @return ResponseEntity Delete task by id endpoint
	 */
	@DeleteMapping("/deleteTask")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> deleteTask(
			@NotNull(message = TaskManagerConstants.NOT_NULL_TASK_ID) @IdTaskConstraint Long idTask)
			throws IllegalArgumentException {

		log.info(String.format(TaskManagerConstants.DELETING_TASK, idTask.toString()));

		boolean deletedTask = taskManagerService.deleteTask(idTask);

		return deletedTask
				? new ResponseEntity<String>(String.format(TaskManagerConstants.DELETED_TASK, idTask.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.DELETING_TASK_ERROR_MESSAGE, idTask.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * @param idTask
	 * @return ResponseEntity Deleting task by id endpoint
	 */
	@PutMapping("/finishTask")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> finishTask(@NotNull(message = TaskManagerConstants.NOT_NULL_TASK_NAME) Long idTask)
			throws IllegalArgumentException {

		log.info(String.format(TaskManagerConstants.FINISHING_TASK, idTask.toString()));

		boolean finishedTask = taskManagerService.finishTask(idTask);

		return finishedTask
				? new ResponseEntity<String>(String.format(TaskManagerConstants.FINISHED_TASK, idTask.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.FINISHING_TASK_ERROR_MESSAGE, idTask.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

}

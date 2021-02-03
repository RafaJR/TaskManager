package com.mimacom.tastkmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.model.InputTask;
import com.mimacom.tastkmanager.model.InputUser;
import com.mimacom.tastkmanager.model.OutputTask;
import com.mimacom.tastkmanager.service.TaskManagerServiceImpl;
import com.mimacom.tastkmanager.validation.TaskConstraint;
import com.mimacom.tastkmanager.validation.UserNameConstraint;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Main controller for Task Manager
 */
@RestController
@Validated
@RequestMapping("/taskmanager")
public class TaskManagerController {

	@Autowired
	TaskManagerServiceImpl taskManagerService;

	@GetMapping("/getUserTasks")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getUserTasks(
			@NotNull(message = TaskManagerConstants.NOT_NULL_USER) @UserNameConstraint String userName) {

		Optional<List<OutputTask>> optListOutputTask = Optional.ofNullable(taskManagerService.getUserTasks(userName));

		return optListOutputTask.isPresent()
				? new ResponseEntity<List<OutputTask>>(optListOutputTask.get(), HttpStatus.OK)
				: new ResponseEntity<String>(String.format(TaskManagerConstants.USER_TASKS_NOT_FOUND, userName),
						HttpStatus.NOT_FOUND);

	}

	@PostMapping("/saveTask")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> saveTask(
			@RequestBody @NotNull(message = TaskManagerConstants.NOT_NULL_TASK) @Valid @TaskConstraint InputTask inputTask) {

		return taskManagerService.saveTask(inputTask)
				? new ResponseEntity<String>(String.format(TaskManagerConstants.NEW_TASK, inputTask.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.SAVING_TASK_ERROR_MESSAGE, inputTask.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/saveUser")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> saveUser(
			@RequestBody @NotNull(message = TaskManagerConstants.NOT_NULL_USER) @Valid InputUser inputUser) {

		return taskManagerService.saveUser(inputUser)
				? new ResponseEntity<String>(String.format(TaskManagerConstants.NEW_USER, inputUser.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.SAVING_USER_ERROR_MESSAGE, inputUser.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

}

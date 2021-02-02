package com.mimacom.tastkmanager.controller;

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
import com.mimacom.tastkmanager.service.TaskManagerServiceImpl;

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

	@PostMapping("/saveTask")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> saveTask(
			@RequestBody @NotNull(message = "The task to save can't be null") @Valid InputTask inputTask) {
		
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
			@RequestBody @NotNull(message = "The user to save can't be null") @Valid InputUser inputUser) {

		return taskManagerService.saveUser(inputUser)
				? new ResponseEntity<String>(String.format(TaskManagerConstants.NEW_USER, inputUser.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TaskManagerConstants.SAVING_USER_ERROR_MESSAGE, inputUser.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/getUserTasks")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getUserTasks(@RequestBody @NotNull String idUser) {

		return new ResponseEntity<String>(taskManagerService.getUserTasks(idUser), HttpStatus.OK);
	}

}

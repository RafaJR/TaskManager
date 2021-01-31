package com.mimacom.tastkmanager.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mimacom.tastkmanager.service.TaskManagerServiceImpl;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Main controller for Task Manager
 */
@RestController
@Validated
@RequestMapping("/taskmanager")
public class TaskManagerController {
	
	@Autowired
	TaskManagerServiceImpl taskManagerService;
	
	@GetMapping("/getUserTasks")
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getUserTasks(@RequestBody @NotNull String idUser) {
		
		return new ResponseEntity<String>((taskManagerService.getUserTasks(idUser)), HttpStatus.OK);
	}

}

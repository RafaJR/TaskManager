package com.mimacom.tastkmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Task Manager API starter
 */
@Slf4j
@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		
		log.info(TaskManagerConstants.TASK_MANAGER_START);
		
		SpringApplication.run(TaskManagerApplication.class, args);
		
		log.info(TaskManagerConstants.TASK_MANAGER_STARTED);
	}

}

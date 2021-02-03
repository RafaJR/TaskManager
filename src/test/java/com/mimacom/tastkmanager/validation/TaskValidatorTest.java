package com.mimacom.tastkmanager.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mimacom.tastkmanager.model.InputTask;

class TaskValidatorTest {
	
	TaskValidator taskValidator = new TaskValidator();

	@Test
	void taskVAlidatorTest() {
		
		// Valid task dates
		InputTask validTask = InputTask.builder()
				.starDate("03/02/2021 16:50")
				.endDate("03/02/2021 17:50")
				.build();
		assertTrue(taskValidator.isValid(validTask, null));
		
		// Not valid task dates
		InputTask notValidTask = InputTask.builder()
				.starDate("03/02/2021 17:50")
				.endDate("03/02/2021 16:50")
				.build();
		assertFalse(taskValidator.isValid(notValidTask, null));
		notValidTask = InputTask.builder()
				.starDate("03/02/2021 18:00")
				.endDate("03/02/2021 18:00")
				.build();
		assertFalse(taskValidator.isValid(notValidTask, null));
	}

}

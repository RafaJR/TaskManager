package com.mimacom.tastkmanager.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.validation.DateConstraint;
import com.mimacom.tastkmanager.validation.TaskNameConstraint;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Input task for updating model
 */

@Data
@ToString
@Builder
public class InputUdateTask {
	
	@NotNull
	private long idTask;
	@NotNull(message=TaskManagerConstants.NOT_NULL_TASK_NAME)
	@TaskNameConstraint
	private String taskName;
	@DateConstraint
	private String starDate;
	@DateConstraint
	private String endDate;
	private Boolean isFinished;
	
	public Task toEntity() {
		
		return Task.builder().taskName(taskName)
				.isFinished(isFinished)
				.startDate(LocalDateTime.parse(starDate, TaskManagerConstants.DATE_FORMAT))
				.endDate(LocalDateTime.parse(endDate, TaskManagerConstants.DATE_FORMAT)).build();
		
	}

}
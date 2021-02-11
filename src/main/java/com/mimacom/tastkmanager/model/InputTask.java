package com.mimacom.tastkmanager.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.entities.Task;
import com.mimacom.tastkmanager.validation.DateConstraint;
import com.mimacom.tastkmanager.validation.TaskNameConstraint;
import com.mimacom.tastkmanager.validation.UserNameConstraint;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Input task model
 */

@Data
@ToString
@Builder
public class InputTask {

	@NotNull(message=TaskManagerConstants.NOT_NULL_TASK_NAME)
	@TaskNameConstraint
	private String taskName;
	@NotNull(message=TaskManagerConstants.NOT_NULL_USER_NAME)
	@UserNameConstraint
	private String userName;
	@NotNull(message=TaskManagerConstants.NOT_NULL_START_DATE)
	@DateConstraint
	private String starDate;
	@NotNull(message=TaskManagerConstants.NOT_NULL_END_DATE)
	@DateConstraint
	private String endDate;

	public Task toEntity() {

		return Task.builder().taskName(taskName)
				.isFinished(false)
				.startDate(LocalDateTime.parse(starDate, TaskManagerConstants.DATE_FORMAT))
				.endDate(LocalDateTime.parse(endDate, TaskManagerConstants.DATE_FORMAT)).build();
	}

}
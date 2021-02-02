package com.mimacom.tastkmanager.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.mimacom.tastkmanager.constants.TaskManagerConstants;
import com.mimacom.tastkmanager.entities.Task;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Input task
 */

@Data
@ToString
@Builder
public class InputTask {

	@NotNull
	private String taskName;
	@NotNull
	private String userName;
	@NotNull
	private String starDate;
	@NotNull
	private String endDate;

	public Task toEntity() {

		return Task.builder().taskName(taskName).isFinished(false)
				.startDate(LocalDateTime.parse(starDate, TaskManagerConstants.DATE_FORMAT))
				.endDate(LocalDateTime.parse(endDate, TaskManagerConstants.DATE_FORMAT)).build();
	}

}
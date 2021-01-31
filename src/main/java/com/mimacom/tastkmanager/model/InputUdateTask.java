package com.mimacom.tastkmanager.model;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Input task for updating
 */

@Data
@ToString
@Builder
public class InputUdateTask {
	
	@NotNull
	private long idTask;
	private String taskName;
	private String starDate;
	private String endDate;

}
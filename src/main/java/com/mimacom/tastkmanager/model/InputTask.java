package com.mimacom.tastkmanager.model;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Input task
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

}
package com.mimacom.tastkmanager.model;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Input user
 */

@Data
@ToString
@Builder
public class InputUser {
	
	@NotNull
	private String userName;
	@NotNull
	private String userEmail;
	@NotNull
	private String userPassword;	

}
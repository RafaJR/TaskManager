package com.mimacom.tastkmanager.model;

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
public class OutputTask {

	private String userName;
	private String userEmail;
	private String userPassword;
	private String state;

}

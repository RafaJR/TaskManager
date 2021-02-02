package com.mimacom.tastkmanager.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserNameValidatorTest {
	
	UserNameValidator userNameValidator = new UserNameValidator();

	@Test
	void userNameValidationTest() {
		
		// Valid user names
		String validUserName = "eusebio123";
		assertTrue(userNameValidator.isValid(validUserName, null));
		validUserName = "eusebio_123";
		assertTrue(userNameValidator.isValid(validUserName, null));
		validUserName = "Eusebio123";
		assertTrue(userNameValidator.isValid(validUserName, null));
		validUserName = "12345678912345678901"; // Max length allowed for the user name
		assertTrue(userNameValidator.isValid(validUserName, null));
		
		// Not valid user names
		String notValidUserName = "";
		assertFalse(userNameValidator.isValid(notValidUserName, null));
		notValidUserName = " ";
		assertFalse(userNameValidator.isValid(notValidUserName, null));
		notValidUserName = "Chindasvinto*";
		assertFalse(userNameValidator.isValid(notValidUserName, null));
		notValidUserName = "ThisNameHasMoreThanTwentyCharacters";
		assertFalse(userNameValidator.isValid(notValidUserName, null));
		notValidUserName = "123456789123456789012"; // Max length allowed for the user name +1
		assertFalse(userNameValidator.isValid(notValidUserName, null));
	}

}

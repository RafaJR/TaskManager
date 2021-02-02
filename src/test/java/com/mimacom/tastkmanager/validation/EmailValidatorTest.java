package com.mimacom.tastkmanager.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailValidatorTest {
	
	EmailValidator emailValidator = new EmailValidator();

	@Test
	void emailValidatorTest() {
		
		
		// Valid email
		String validEmail = "email@domain.com";
		assertTrue(emailValidator.isValid(validEmail, null));
		validEmail = "elPisuergaPasa@porValladolid.es";
		assertTrue(emailValidator.isValid(validEmail, null));
		validEmail = "rafael.jimenez.reina@gmail.com";
		assertTrue(emailValidator.isValid(validEmail, null));
		
		// Not valid email
		assertTrue(emailValidator.isValid(validEmail, null));
		String notValidEmail = "";
		assertFalse(emailValidator.isValid(notValidEmail, null));
		notValidEmail = "98ds";
		assertFalse(emailValidator.isValid(notValidEmail, null));
		notValidEmail = "email#domain.com";
		assertFalse(emailValidator.isValid(notValidEmail, null));
		notValidEmail = "email@domain.tooLongDomain";
		assertFalse(emailValidator.isValid(notValidEmail, null));
	}

}

package com.mimacom.tastkmanager.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PasswordValidatorTest {
	
	PasswordValidator passwordValidator = new PasswordValidator();

	@Test
	void passwordValidatorTest() {

		// Valid passwords
		String validPassord = "ihoSu2Djx7*udsy";
		assertTrue(passwordValidator.isValid(validPassord, null));
		validPassord = "8i8djm*o88ches9X+ih4";
		assertTrue(passwordValidator.isValid(validPassord, null));
		validPassord = "8i8Djm*o";
		assertTrue(passwordValidator.isValid(validPassord, null));
		
		// Not valid passwords
		String notValidPassord = "";
		assertFalse(passwordValidator.isValid(notValidPassord, null));
		notValidPassord = "e*·T456";
		assertFalse(passwordValidator.isValid(notValidPassord, null));
		notValidPassord = "8i8djm*o88ches9X+ih4+"; // Too long
		assertFalse(passwordValidator.isValid(notValidPassord, null));
		notValidPassord = "7i8Djm*"; // Too short
		assertFalse(passwordValidator.isValid(notValidPassord, null));
	}

}

package de.telekom.sea2.model;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;

public class PersonTest {

	private Person cut;

	@BeforeEach
	void setup() {
		cut = new Person();
	}

	@Test
	void setFirstnamme_test() {

//	fail();
//	Assertion.fail();

		// Arrange
		cut.setFirstname("TestFirstName");

		// Act
		var result = cut.getFirstname();

		// Assert
		assertEquals("TestFirstame", result);
	}

	@AfterEach
	void teardown() {
		cut = null;
	}

}

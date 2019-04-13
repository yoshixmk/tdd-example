package xunit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseTest {

	WasRun test;

	@BeforeEach
	void setUp() {
		test = new WasRun("testMethod");
		test.run();
	}

	@Test
	void testSetUp() {
		assertTrue(test.wasSetUp());
	}

	@Test
	void testRunning() {
		test.run();
		assertTrue(test.wasRun());
	}

}

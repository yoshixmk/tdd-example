package xunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseTest {

	WasRun test;

	private String log = "";

	@BeforeEach
	void setUp() {
		test = new WasRun(log);
		log += "setup ";
	}

	@Test
	void testTemplateMethod() {
		test.run();
		assertEquals(test.getLog(), "setup testMethod");
	}

}

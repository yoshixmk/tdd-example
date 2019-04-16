package xunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseTest implements TestCase {

	WasRun test;

	@BeforeEach
	public void setUp() {
		test = new WasRun();
		test.addLog("setup ");
		System.out.println(test.getLog());
	}

	@AfterEach
	public void teardown() {
		test.addLog("tearDown ");
		System.out.println(test.getLog());
	}

	@Test
	public void testTemplateMethod() {
		test.addLog("testMethod ");
		test.run();
		assertEquals(test.getLog(), "setup testMethod ");
	}

}

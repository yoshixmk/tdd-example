package xunit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestCase {
	@Test
	void testRunning() {
		final WasRun test = new WasRun("testMethod");
		assertFalse(test.wasRun());
		test.run();
		assertTrue(test.wasRun());
	}
}

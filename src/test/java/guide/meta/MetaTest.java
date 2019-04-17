package guide.meta;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MetaTest {

	@PrimaryTest
	void arrayEqualsTest() {
		int[] actual = new int[3];
		Arrays.fill(actual, 1);
		assertArrayEquals(new int[] { 1, 1, 1 }, actual);
	}

	@Test
	void Primary‚Å‚Í‚È‚¢Test() {
		assertEquals(1, 1);
	}
}

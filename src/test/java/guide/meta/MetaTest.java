package guide.meta;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

class MetaTest {

	@PrimaryTest
	void arrayEqualsTest() {
		int[] actual = new int[3];
		Arrays.fill(actual, 1);
		assertArrayEquals(new int[] { 1, 1, 1 }, actual);
	}
}

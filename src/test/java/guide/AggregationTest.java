package guide;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AggregationTest {

	// lamda multiple test
	@Test
	void groupedAssertions() {
		assertAll("string case", () -> assertEquals("123abc", "123ABC".toLowerCase()),
				() -> assertEquals("UPPER", "Upper".toUpperCase()));
	}

	// csv multiple test
	@ParameterizedTest
	@CsvSource({ "foo, 1", "bar, 2", "baz, 3" })
	void testWithCsvSource(String first, int second) {
		assertNotNull(first);
		assertNotEquals(0, second);
	}

	// value multiple test
	@ParameterizedTest
	@ValueSource(strings = { "foo", "bar", "baz" })
	void palindromes(String candidate) {
		assertTrue(candidate.length() > 0);
	}

}

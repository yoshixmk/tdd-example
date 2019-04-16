package suite;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TestSuiteTest {

	// lamdaを使って複数 テスト
	@Test
	void groupedAssertions() {
		assertAll("string case", 
				() -> assertEquals("123abc", "123ABC".toLowerCase()),
				() -> assertEquals("UPPER", "Upper".toUpperCase()));
	}

	// csv形式で複数テスト
	@ParameterizedTest
	@CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
	void testWithCsvSource(String first, int second) {
		assertNotNull(first);
		assertNotEquals(0, second);
	}

	// valueを直接与えて複数テスト
	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
		assertTrue(candidate.length() > 0);
	}

}

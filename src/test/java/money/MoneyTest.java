package money;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void testMultiplication() {
		Dollar five = new Dollar(5);
		five.times(5);
		assertEquals(10, five.mount);
	}

}

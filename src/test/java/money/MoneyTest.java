package money;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void testMultiplication() {
		Dollar five = new Dollar(5);
		assertEquals(new Dollar(10), five.times(2));
		assertEquals(new Dollar(15), five.times(3));
	}
	
	@Test
	void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));
	}

}

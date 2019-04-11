package money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}

	@Test
	void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}

	@Test
	void testFrancMultiplication() {
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}

	@Test
	void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}

	@Test
	void testSimpleAddition() {
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), reduced);
	}
	
	@Test
	void testReduceSum() {
		final Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		final Bank bank = new Bank();
		final Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(7), result);
	}
	
	@Test
	void testReduceMoneyDifferentCurrency() {
		final Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		final Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}
	
	@Test
	void testMixedAddition() {
		final Expression fiveBucks = Money.dollar(5);
		final Expression tenFrancs = Money.franc(10);
		final Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		final Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10), result);
	}
	
	@Test
	void testSumPlusMoney() {
		final Expression fiveBucks = Money.dollar(5);
		final Money tenFrancs = Money.franc(10);
		final Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		final Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
		final Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(15), result);
	}
	
	@Test
	void testSumTimes() {
		final Expression fiveBucks = Money.dollar(5);
		final Money tenFrancs = Money.franc(10);
		final Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		final Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
		final Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
	}
}

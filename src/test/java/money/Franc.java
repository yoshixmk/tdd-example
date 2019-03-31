package money;

public class Franc extends Money {

	public Franc(int amount, String currency) {
		super.amount = amount;
		super.currency = currency;
	}

	@Override
	public Money times(int multiplier) {
		return Money.franc(this.amount * multiplier);
	}
}

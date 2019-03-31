package money;

public class Franc extends Money {

	public Franc(int amount) {
		super.amount = amount;
		super.currency = "CHF";
	}

	@Override
	public Money times(int multiplier) {
		return new Franc(this.amount * multiplier);
	}
}

package money;

public class Dollar extends Money {

	public Dollar(int mount, String currency) {
		super.amount = mount;
		super.currency = currency;
	}

	@Override
	public Money times(int multiplier) {
		return Money.dollar(this.amount * multiplier);
	}

}

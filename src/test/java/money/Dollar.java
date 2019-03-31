package money;

public class Dollar extends Money {

	public Dollar(int mount) {
		super.amount = mount;
		super.currency = "USD";
	}

	@Override
	public Money times(int multiplier) {
		return new Dollar(this.amount * multiplier);
	}

}

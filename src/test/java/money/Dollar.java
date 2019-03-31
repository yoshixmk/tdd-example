package money;

public class Dollar extends Money {

	public Dollar(int mount) {
		this.amount = mount;
	}

	public Dollar times(int multiplier) {
		return new Dollar(this.amount * multiplier);
	}

}

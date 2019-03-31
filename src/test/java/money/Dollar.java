package money;

public class Dollar {

	private int amount;
	
	public Dollar(int mount) {
		this.amount = mount;
	}

	public Dollar times(int multiplier) {
		return new Dollar(this.amount * multiplier);
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.amount == ((Dollar)obj).amount;
	}

}

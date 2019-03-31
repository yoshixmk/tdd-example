package money;

public class Money {

	protected int amount;

	public Money() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		return this.amount == ((Franc)obj).amount;
	}

}
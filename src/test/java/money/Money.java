package money;

public class Money {

	protected int amount;

	public Money() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		final Money money = (Money)obj;
		return this.amount == money.amount
				&& getClass().equals(money.getClass());
	}

}
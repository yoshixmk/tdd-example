package money;

abstract class Money {

	protected int amount;

	public Money() {
		super();
	}
	
	abstract Money times(int multiplier);
	
	static Dollar dollar(int amount) {
		return new Dollar(amount);
	}
	
	static Franc franc(int amount) {
		return new Franc(amount);
	}

	@Override
	public boolean equals(Object obj) {
		final Money money = (Money)obj;
		return this.amount == money.amount
				&& getClass().equals(money.getClass());
	}

}
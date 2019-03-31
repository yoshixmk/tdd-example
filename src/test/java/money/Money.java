package money;

public class Money {

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public Money times(int multiplier) {
		return new Money(this.amount * multiplier, this.currency);
	}
	
	public String currency() {
		return this.currency;
	}
	
	static Money dollar(int amount) {
		return new Dollar(amount, "USD");
	}
	
	static Franc franc(int amount) {
		return new Franc(amount, "CHF");
	}

	@Override
	public boolean equals(Object obj) {
		final Money money = (Money)obj;
		return this.amount == money.amount
				&& this.currency.equals(money.currency);
	}
	
	@Override
	public String toString() {
		return this.amount + " " + this.currency;
	}

}
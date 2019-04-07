package money;

public class Money implements Expression {

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
		return new Money(amount, "USD");
	}

	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}

	@Override
	public Money reduce(String to) {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		final Money money = (Money) obj;
		return this.amount == money.amount && this.currency.equals(money.currency);
	}

	@Override
	public String toString() {
		return this.amount + " " + this.currency;
	}


}
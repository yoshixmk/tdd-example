package money;

public class Sum implements Expression {
	private Money augend;

	private Money addend;

	public Sum(Money augend, Money addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Money getAugend() {
		return augend;
	}

	public Money getAddend() {
		return addend;
	}

	@Override
	public Money reduce(Bank bank, String to) {
		int amount = this.augend.amount + this.addend.amount; 
		return new Money(amount, to);
	}
}

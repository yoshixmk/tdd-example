package money;

public class Sum implements Expression {
	private Expression augend;

	private Expression addend;

	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Expression getAugend() {
		return augend;
	}

	public Expression getAddend() {
		return addend;
	}
	
	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

	@Override
	public Money reduce(Bank bank, String to) {
		int amount = this.augend.reduce(bank, to).amount + this.addend.reduce(bank, to).amount; 
		return new Money(amount, to);
	}

	@Override
	public Expression times(int multiplier) {
		return new Sum(this.augend.times(multiplier), this.addend.times(multiplier));
	}
}

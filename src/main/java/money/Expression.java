package money;

interface Expression {

	Money reduce(Bank bank, String to2);

	Expression plus(Expression addend);

}

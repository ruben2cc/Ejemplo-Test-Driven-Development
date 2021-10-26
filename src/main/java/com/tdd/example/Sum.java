package com.tdd.example;

public class Sum implements Expression{

	public Expression augmend;
	public Expression addmend;
	
	public Sum(Expression augmend, Expression addmend) {
		this.augmend = augmend;
		this.addmend = addmend;
	}

	@Override
	public Money reduce(Bank bank, String toCurrency) {		
		int amount = addmend.reduce(bank, toCurrency).amount + augmend.reduce(bank, toCurrency).amount;		
		return new Money(amount, toCurrency);
	}

	@Override
	public Expression plus(Expression expression) {
		
		return new Sum(augmend.plus(expression), addmend);
	}

	@Override
	public Expression times(int multiplier) {
		return new Sum(augmend.times(multiplier), addmend.times(multiplier));
	}

}

package com.tdd.example;

public class Money implements Expression{
	protected int amount;
	protected String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount && this.currency.equals(money.currency);
	}

	protected String currency() {
		return currency;
	}

	@Override
	public Expression times(int multiplier) {
		return new Money(amount * multiplier, this.currency);
	}
	
	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

	@Override
	public Money reduce(Bank bank, String toCurrency) {

		return new Money(amount / bank.rate(currency, toCurrency), toCurrency);
		//return this;
	}

}

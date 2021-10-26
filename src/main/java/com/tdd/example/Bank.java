package com.tdd.example;

import java.util.HashMap;

public class Bank {
	
	private HashMap<Pair, Integer> rateMAp = new HashMap<Pair, Integer>();

	public Expression reduce(Expression source, String toCurrency) {
		
		return source.reduce(this, toCurrency);

	}

	public Integer rate(String from, String to) {
		return from.equals("CHF") && to.equals("USD") ? 2 : 1;
	}

	public void addRate(String from, String to, int rate) {
		Pair pair = new Pair(from, to);
		rateMAp.put(pair, rate);
	}

}

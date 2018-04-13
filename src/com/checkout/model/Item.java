package com.checkout.model;

public enum Item {
	APPLE(60), ORANGE(25); 
	
	Item(long cost) {
		this.cost = cost;
	}
	
	private final long cost;
	
	public long getCost() {
		return cost;
	}
}

package com.checkout.model;

public enum Offer {
	BUY_ONE_GET_ONE_APPLE(Item.APPLE), BUY_ONE_GET_ONE_ORANGE(Item.ORANGE), THREE_FOR_PRICE_TWO_ORANGE(Item.ORANGE),
	THREE_FOR_PRICE_TWO_APPLE(Item.APPLE);
	
	Offer(Item item) {
		this.item = item;
	}
	
	private final Item item;
	
	public Item getItem() {
		return item;
	}
}

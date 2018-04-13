package com.checkout.decorator;

import java.util.List;

public interface CheckoutDecorator {
	public String format(List<String> items, double totalCost);
}

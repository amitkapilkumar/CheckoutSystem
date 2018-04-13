package com.checkout;

import java.util.List;

import com.checkout.model.Offer;

public interface CheckoutSystem {
	public String checkout(List<String> items);
	public String checkout(List<String> items, List<Offer> offers);
}

package com.checkout.service;

import java.util.Map;

import com.checkout.model.Item;

public interface CheckoutService {
	public double calculateBill(Map<Item, Integer> items);
}
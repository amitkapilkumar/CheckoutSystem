package com.checkout.service;

import java.util.Map;
import java.util.Map.Entry;

import com.checkout.model.Item;

public class CheckoutServiceImpl implements CheckoutService {

	@Override
	public double calculateBill(Map<Item, Integer> items) {
		double costs = 0;
		for(Entry<Item, Integer> entry: items.entrySet()) {
			costs += entry.getKey().getCost() * entry.getValue();
		}
		costs = costs / 100;
		return Math.round(costs * 100.0)/100.0; // return amount in pounds
	}
}

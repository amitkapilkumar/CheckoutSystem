package com.checkout.service;

import java.util.List;
import java.util.Map;

import com.checkout.model.Item;
import com.checkout.model.Offer;

public interface CheckoutService {
	public double calculateBill(Map<Item, Integer> items);
	public double calculateBill(Map<Item, Integer> items, List<Offer> offers);
}
package com.checkout.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.checkout.model.Item;
import com.checkout.model.Offer;

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
	
	@Override
	public double calculateBill(Map<Item, Integer> items, List<Offer> offers) {
		double costs = calculateBill(items) * 100;
		double discount = 0;
		for(Offer offer : offers) {
			switch(offer) {
				case BUY_ONE_GET_ONE_APPLE:
				case BUY_ONE_GET_ONE_ORANGE:
					discount += (items.get(offer.getItem())/2) * offer.getItem().getCost(); 
					break;
				case THREE_FOR_PRICE_TWO_ORANGE:
				case THREE_FOR_PRICE_TWO_APPLE:	
					discount += (items.get(offer.getItem())/3) * offer.getItem().getCost();
					break;
				default:
					break;
			}
		}
		costs = (costs - discount)/100;
		return Math.round(costs * 100.0)/100.0; // return amount in pounds
	}
}

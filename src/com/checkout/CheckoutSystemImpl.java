package com.checkout;

import java.util.List;
import java.util.Map;

import com.checkout.decorator.CheckoutDecorator;
import com.checkout.decorator.CheckoutDecoratorImpl;
import com.checkout.mapper.CheckoutMapper;
import com.checkout.mapper.CheckoutMapperImpl;
import com.checkout.model.Item;
import com.checkout.model.Offer;
import com.checkout.service.CheckoutService;
import com.checkout.service.CheckoutServiceImpl;

public class CheckoutSystemImpl implements CheckoutSystem {
	private CheckoutMapper checkoutMapper;
	private CheckoutService checkoutService;
	private CheckoutDecorator checkoutDecorator;
	
	public CheckoutSystemImpl() {
		checkoutMapper = new CheckoutMapperImpl();
		checkoutService = new CheckoutServiceImpl();
		checkoutDecorator = new CheckoutDecoratorImpl();
	}
	
	public CheckoutSystemImpl(CheckoutMapper checkoutMapper, CheckoutService checkoutService, CheckoutDecorator checkoutDecorator) {
		this.checkoutMapper = checkoutMapper;
		this.checkoutService = checkoutService;
		this.checkoutDecorator = checkoutDecorator;
	}

	@Override
	public String checkout(List<String> items) {
		Map<Item, Integer> itemsForCheckout = checkoutMapper.parseAndMapTo(items);
		double totalCost = checkoutService.calculateBill(itemsForCheckout);
		return checkoutDecorator.format(items, totalCost);
	}

	@Override
	public String checkout(List<String> items, List<Offer> offers) {
		Map<Item, Integer> itemsForCheckout = checkoutMapper.parseAndMapTo(items);
		double totalCost = checkoutService.calculateBill(itemsForCheckout, offers);
		return checkoutDecorator.format(items, totalCost);
	}
	
}

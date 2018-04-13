package com.checkout;

import java.util.List;
import java.util.Map;

import com.checkout.decorator.CheckoutDecorator;
import com.checkout.decorator.CheckoutDecoratorImpl;
import com.checkout.mapper.CheckoutMapper;
import com.checkout.mapper.CheckoutMapperImpl;
import com.checkout.model.Item;
import com.checkout.service.CheckoutService;
import com.checkout.service.CheckoutServiceImpl;
import com.checkout.service.CheckoutServiceImplTest;

public class CheckoutSytemImpl implements CheckoutSystem {
	private CheckoutMapper checkoutMapper;
	private CheckoutService checkoutService;
	private CheckoutDecorator checkoutDecorator;
	
	public CheckoutSytemImpl() {
		checkoutMapper = new CheckoutMapperImpl();
		checkoutService = new CheckoutServiceImpl();
		checkoutDecorator = new CheckoutDecoratorImpl();
	}
	
	public CheckoutSytemImpl(CheckoutMapper checkoutMapper, CheckoutService checkoutService, CheckoutDecorator checkoutDecorator) {
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
	
}

package com.checkout.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.checkout.model.Item;

public class CheckoutServiceImplTest {
	private CheckoutServiceImpl checkoutServiceImpl;
	
	@Before
	public void setup() {
		checkoutServiceImpl = new CheckoutServiceImpl();
	}

	@Test
	public void testCalculateBillWithEmpty() {
		Map<Item, Integer> items = new HashMap<>();
		
		double totalCost = checkoutServiceImpl.calculateBill(items);
		Assert.assertEquals(0.00, totalCost, 0.00);
	}
	
	@Test
	public void testCalculateBillWithMutipleItems() {
		Map<Item, Integer> items = new HashMap() {{
			put(Item.APPLE, 3);
			put(Item.ORANGE, 2);
		}};
		
		double totalCost = checkoutServiceImpl.calculateBill(items);
		Assert.assertEquals(2.30, totalCost, 0.00);
	}
	
	@Test
	public void testCalculateBillSingleTypeItems() {
		Map<Item, Integer> items = new HashMap() {{
			put(Item.APPLE, 3);
		}};
		
		double totalCost = checkoutServiceImpl.calculateBill(items);
		Assert.assertEquals(1.80, totalCost, 0.00);
	}
	
	@Test
	public void testCalculateBillWithSingleApple() {
		Map<Item, Integer> items = new HashMap() {{
			put(Item.APPLE, 1);
		}};
		
		double totalCost = checkoutServiceImpl.calculateBill(items);
		Assert.assertEquals(0.60, totalCost, 0.00);
	}

	@Test
	public void testCalculateBillWithSingleOrange() {
		Map<Item, Integer> items = new HashMap() {{
			put(Item.ORANGE, 1);
		}};
		
		double totalCost = checkoutServiceImpl.calculateBill(items);
		Assert.assertEquals(0.25, totalCost, 0.00);
	}
}
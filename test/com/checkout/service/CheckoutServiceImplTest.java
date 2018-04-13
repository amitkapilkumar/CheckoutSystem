package com.checkout.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.checkout.factory.OfferManagerFactory;
import com.checkout.model.Item;
import com.checkout.model.Offer;

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
	
	@Test
	public void testCalculateBillWithOffers() {
		List<Offer> offers = new ArrayList() {{
			add(OfferManagerFactory.getInstance().buildOfferBuyOneGetOneForApple());
		}};
		
		Map<Item, Integer> items = new HashMap() {{
			put(Item.APPLE, 3);
		}};
		
		double totalCost = checkoutServiceImpl.calculateBill(items, offers);
		Assert.assertEquals(1.20, totalCost, 0.00);
	}
	
	@Test
	public void testCalculateBillWithMutipleOffersMutipleItems() {
		List<Offer> offers = new ArrayList() {{
			add(OfferManagerFactory.getInstance().buildOfferBuyOneGetOneForApple());
			add(OfferManagerFactory.getInstance().buildOfferThreeForPriceTwoForOrange());
		}};
		
		Map<Item, Integer> items = new HashMap() {{
			put(Item.APPLE, 9);
			put(Item.ORANGE, 7);
		}};
		
		double totalCost = checkoutServiceImpl.calculateBill(items, offers);
		Assert.assertEquals(4.25, totalCost, 0.00);
	}
}
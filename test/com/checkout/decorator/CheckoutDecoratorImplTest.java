package com.checkout.decorator;

import static com.checkout.util.Constants.POUND;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CheckoutDecoratorImplTest {
	private CheckoutDecoratorImpl checkoutDecoratorImpl;
	
	@Before
	public void setup() {
		checkoutDecoratorImpl = new CheckoutDecoratorImpl();
	}
	
	@Test
	public void testFormatWithMutipleValue() {
		List<String> list = new ArrayList() {{
			add("Apple");
			add("Apple");
			add("Orange");
		}};
		
		double cost = 1.65;
		String expectedFormat = "[Apple, Apple, Orange] => " + POUND + "1.65";
		Assert.assertEquals(expectedFormat, checkoutDecoratorImpl.format(list, cost));
	}
	
	@Test
	public void testFormatWithSingleValue() {
		List<String> list = new ArrayList() {{
			add("Apple");
		}};
		
		double cost = 0.65;
		String expectedFormat = "[Apple] => " + POUND + "0.65";
		Assert.assertEquals(expectedFormat, checkoutDecoratorImpl.format(list, cost));
	}
}

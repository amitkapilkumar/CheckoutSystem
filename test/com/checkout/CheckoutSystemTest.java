package com.checkout;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.checkout.factory.CheckoutSystemFactory;


public class CheckoutSystemTest {
	private CheckoutSystem checkoutSystem;
	
	@Before
	public void setup() {
		checkoutSystem = CheckoutSystemFactory.getInstance();
	}

	@Test
	public void testCheckout() {
		List<String> list = new ArrayList() {{
			add("Apple");
			add("Apple");
			add("Orange");
			add("Apple");
		}};
		
		String output = checkoutSystem.checkout(list);
		Assert.assertEquals("[Apple, Apple, Orange, Apple] => £2.05", output);
	}

}

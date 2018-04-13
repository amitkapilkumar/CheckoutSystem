package com.checkout.factory;

import com.checkout.CheckoutSystem;
import com.checkout.CheckoutSystemImpl;

public class CheckoutSystemFactory {
	private static CheckoutSystem checkoutSystem;
	
	public static CheckoutSystem getInstance() {
		if(checkoutSystem == null) {
			checkoutSystem = new CheckoutSystemImpl();
		}
		return checkoutSystem;
	}
}

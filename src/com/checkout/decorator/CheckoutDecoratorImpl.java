package com.checkout.decorator;

import java.util.List;
import static com.checkout.util.Constants.POUND;

public class CheckoutDecoratorImpl implements CheckoutDecorator {

	@Override
	public String format(List<String> items, double totalCost) {
		StringBuilder list = new StringBuilder();
		for(String item : items) {
			list.append(item + ", ");
		}
		String str = list.toString().trim();
		str = str.substring(0, str.length()-1); // exclude last comma
		return "[" + str + "] => " + POUND + totalCost; 
	}

}

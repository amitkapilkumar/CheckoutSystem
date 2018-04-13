package com.checkout.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.checkout.model.Item;

public class CheckoutMapperImpl implements CheckoutMapper {

	@Override
	public Map<Item, Integer> parseAndMapTo(List<String> itemList) {
		Map<Item, Integer> items = new HashMap<>();
		for(String item : itemList) {
			Item key = Item.valueOf(item.toUpperCase());
			if(items.containsKey(key)) {
				items.put(key, items.get(key) + 1); 
			}
			else {
				items.put(key, 1);
			}
		}
		return items;
	}

}

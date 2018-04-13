package com.checkout.mapper;

import java.util.List;
import java.util.Map;

import com.checkout.model.Item;

public interface CheckoutMapper {
	public Map<Item, Integer> parseAndMapTo(List<String> itemList);
}

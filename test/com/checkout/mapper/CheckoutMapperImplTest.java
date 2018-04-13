package com.checkout.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.checkout.model.Item;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckoutMapperImplTest {
	private CheckoutMapperImpl checkoutMapperImpl;
	
	@Before
	public void setup() {
		checkoutMapperImpl = new CheckoutMapperImpl();
	}

	@Test
	public void testParseAndMapToWithMutipleValues() {
		List<String> list = new ArrayList() {{
			add("Apple");
			add("Orange");
			add("Apple");
			add("Orange");
			add("Orange");
		}};
		
		Map<Item, Integer> items = checkoutMapperImpl.parseAndMapTo(list);
		Assert.assertTrue(items.containsKey(Item.APPLE));
		Assert.assertTrue(items.containsKey(Item.ORANGE));
		Assert.assertEquals(items.get(Item.APPLE).intValue(), 2);
		Assert.assertEquals(items.get(Item.ORANGE).intValue(), 3);
	}
	
	@Test
	public void testParseAndMapToWithTwoDifferentValues() {
		List<String> list = new ArrayList() {{
			add("Apple");
			add("Orange");
		}};
		
		Map<Item, Integer> items = checkoutMapperImpl.parseAndMapTo(list);
		Assert.assertTrue(items.containsKey(Item.APPLE));
		Assert.assertTrue(items.containsKey(Item.ORANGE));
		Assert.assertEquals(items.get(Item.APPLE).intValue(), 1);
		Assert.assertEquals(items.get(Item.ORANGE).intValue(), 1);
	}
	
	@Test
	public void testParseAndMapToWithTwoSameValues() {
		List<String> list = new ArrayList() {{
			add("Apple");
			add("Apple");
		}};
		
		Map<Item, Integer> items = checkoutMapperImpl.parseAndMapTo(list);
		Assert.assertTrue(items.containsKey(Item.APPLE));
		Assert.assertTrue(!items.containsKey(Item.ORANGE));
		Assert.assertEquals(items.get(Item.APPLE).intValue(), 2);
		Assert.assertEquals(items.get(Item.ORANGE), null);
	}
	
	@Test
	public void testParseAndMapToWithEmpty() {
		List<String> list = new ArrayList<>();
		
		Map<Item, Integer> items = checkoutMapperImpl.parseAndMapTo(list);
		Assert.assertTrue(!items.containsKey(Item.APPLE));
		Assert.assertTrue(!items.containsKey(Item.ORANGE));
		Assert.assertEquals(items.get(Item.APPLE), null);
		Assert.assertEquals(items.get(Item.ORANGE), null);
	}
}

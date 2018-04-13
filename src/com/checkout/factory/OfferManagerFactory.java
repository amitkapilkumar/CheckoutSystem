package com.checkout.factory;

import com.checkout.builder.OfferManager;
import com.checkout.builder.OfferManagerImpl;

public class OfferManagerFactory {
	private static OfferManager offerManager;
	
	public static OfferManager getInstance() {
		if(offerManager == null) {
			offerManager = new OfferManagerImpl();
		}
		return offerManager;
	}
}

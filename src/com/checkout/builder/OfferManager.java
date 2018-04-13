package com.checkout.builder;

import com.checkout.model.Offer;

public interface OfferManager {
	public Offer buildOfferBuyOneGetOneForApple();
	public Offer buildOfferBuyOneGetOneForOrange();
	public Offer buildOfferThreeForPriceTwoForApple();
	public Offer buildOfferThreeForPriceTwoForOrange();
}

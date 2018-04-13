package com.checkout.builder;

import com.checkout.model.Offer;

public class OfferManagerImpl implements OfferManager {

	@Override
	public Offer buildOfferBuyOneGetOneForApple() {
		return Offer.BUY_ONE_GET_ONE_APPLE;
	}

	@Override
	public Offer buildOfferBuyOneGetOneForOrange() {
		return Offer.BUY_ONE_GET_ONE_ORANGE;
	}

	@Override
	public Offer buildOfferThreeForPriceTwoForApple() {
		return Offer.THREE_FOR_PRICE_TWO_APPLE;
	}

	@Override
	public Offer buildOfferThreeForPriceTwoForOrange() {
		return Offer.THREE_FOR_PRICE_TWO_ORANGE;
	}

}

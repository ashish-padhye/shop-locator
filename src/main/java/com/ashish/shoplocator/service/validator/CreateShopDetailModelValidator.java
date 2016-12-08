package com.ashish.shoplocator.service.validator;

import org.springframework.stereotype.Component;

import com.ashish.shoplocator.api.validator.AbstractValidator;
import com.ashish.shoplocator.model.ShopDetailModel;

@Component
public class CreateShopDetailModelValidator extends AbstractValidator<ShopDetailModel> {
	
	private static final String SHOP_LONGITUDE = "Shop Longitude";
	private static final String SHOP_LATITUDE = "Shop Latitude";

	@Override
	public void validate(ShopDetailModel shopDetailModel) throws RuntimeException {
		//Any Business validations on the shopDetailModel go here..
		validateBlankString(SHOP_LATITUDE, String.valueOf(shopDetailModel.getShopLatitude()));
		validateBlankString(SHOP_LONGITUDE, String.valueOf(shopDetailModel.getShopLongitude()));
	}
}

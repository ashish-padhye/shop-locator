package com.ashish.shoplocator.service;

import com.ashish.shoplocator.model.ShopDetailModel;

public interface RetailManagerService {

	ShopDetailModel createRetailManagerShop(ShopDetailModel validateCreateUserRewardTransaction) throws RuntimeException;
	
	ShopDetailModel getClosestShopDetails(
			String customerLatitude, String customerLongitude)
			throws RuntimeException;
	
}

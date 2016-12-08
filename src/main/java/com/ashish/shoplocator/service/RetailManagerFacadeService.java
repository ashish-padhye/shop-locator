package com.ashish.shoplocator.service;

import com.ashish.shoplocator.dto.CustomerResponseDto;
import com.ashish.shoplocator.dto.RetailManagerRequestDto;
import com.ashish.shoplocator.dto.RetailManagerResponseDto;

public interface RetailManagerFacadeService {

	RetailManagerResponseDto createRetailManagerShop(RetailManagerRequestDto userRewardTransaction) throws RuntimeException;
	
	CustomerResponseDto getClosestShopDetails(String customerLatitude, String customerLongitude) throws RuntimeException;
	
}
